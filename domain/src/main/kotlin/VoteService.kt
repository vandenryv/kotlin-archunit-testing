package org.hexavote.domain

import CommonUtils.newUuid
import org.hexavote.domain.errors.VoteNotFoundError
import org.hexavote.domain.inplug.IVoteService
import org.hexavote.domain.model.Ballot
import org.hexavote.domain.model.Candidate
import org.hexavote.domain.model.Vote
import org.hexavote.domain.model.Voter
import org.hexavote.domain.outplug.IVoteRepo

open class VoteService(val repo: IVoteRepo) : IVoteService {

    override fun voterVotes(vote: Vote, voter: Voter, ballot: Ballot) {
        // No link between the two it is important
        vote.ballots.add(ballot)
        vote.voters.add(voter)

        repo.saveVote(vote)
    }

    override fun newVote(name: String, proposition: String, candidates: List<Candidate>): Vote {
        val vote = Vote(null, name, proposition, candidates)
        repo.saveVote(vote)
        return vote
    }

    override fun computeResult(voteId: String): List<Candidate> {
        val vote = repo.getVote(voteId) ?: throw VoteNotFoundError(voteId)
        return recursiveRound(vote.ballots)
    }

    override fun getVote(id: String): Vote? {
        return repo.getVote(id)
    }

    override fun saveVote(vote: Vote): Vote {
        vote.id = newUuid()
        return repo.saveVote(vote)
    }

    private fun recursiveRound(ballots: List<Ballot>, eliminated: List<Candidate> = emptyList()): List<Candidate> {
        val result = ballots.map { ballot -> ballot.orderedChoices.first { !eliminated.contains(it) } }
            .fold(HashMap<Candidate, Int>()) { acc, candidate ->
                acc.also {
                    it.compute(candidate) { _, count -> (count ?: 0) + 1 }
                }
            }
            .toList()
            .sortedBy { it.second }
            .reversed()
        return if (result.size == 2) {
            result.map { (candidate, _) -> candidate } + eliminated.reversed()
        } else {
            recursiveRound(ballots, eliminated.withAdded(result.last().first))
        }
    }
}

fun <T> List<T>.withAdded(value: T): List<T> {
    val mutableList = ArrayList<T>(this)
    mutableList.add(value)
    return mutableList
}