package org.hexavote.domain.inplug

import org.hexavote.domain.model.Ballot
import org.hexavote.domain.model.Candidate
import org.hexavote.domain.model.Vote
import org.hexavote.domain.model.Voter

interface IVoteService {

    fun voterVotes(vote: Vote, voter: Voter, ballot: Ballot)

    fun newVote(name: String, proposition: String, candidates: List<Candidate>): Vote

    fun computeResult(voteId: String): List<Candidate>

    fun getVote(id: String): Vote?

    fun saveVote(vote: Vote): Vote
}