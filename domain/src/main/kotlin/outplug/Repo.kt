package org.hexavote.domain.outplug

import org.hexavote.domain.model.Ballot
import org.hexavote.domain.model.Candidate
import org.hexavote.domain.model.Vote
import org.hexavote.domain.model.Voter

interface IVoteRepo {
    fun saveVote(vote: Vote): Vote
    fun getVote(id: String): Vote?
}

interface VoterRepo {
    fun saveVoter(voter: Voter): Voter
    fun getVoter(id: String): Voter?
}

interface CandidateRepo {
    fun saveCandidate(candidate: Candidate): Candidate
    fun getCandidate(id: String): Candidate?
}

interface BallotRepo {
    fun saveBallot(ballot: Ballot): Ballot
    fun getBallot(): Ballot?
}