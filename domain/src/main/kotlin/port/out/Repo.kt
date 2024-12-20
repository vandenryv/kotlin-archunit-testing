package org.hexavote.domain.port.out

import org.hexavote.domain.model.Ballot
import org.hexavote.domain.model.Candidate
import org.hexavote.domain.model.Vote
import org.hexavote.domain.model.Voter

interface VotePort {
    fun saveVote(vote: Vote): Vote
    fun getVote(id: String): Vote?
}

interface VoterPort {
    fun saveVoter(voter: Voter): Voter
    fun getVoter(id: String): Voter?
}

interface CandidatePort {
    fun saveCandidate(candidate: Candidate): Candidate
    fun getCandidate(id: String): Candidate?
}

interface BallotPort {
    fun saveBallot(ballot: Ballot): Ballot
    fun getBallot(): Ballot?
}