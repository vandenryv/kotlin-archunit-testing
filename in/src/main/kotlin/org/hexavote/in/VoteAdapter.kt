package org.hexavote.`in`

import org.hexavote.domain.model.Vote
import org.hexavote.domain.port.`in`.VotePort

class VoteAdapter(
    private val voteService: VotePort
) {
    fun getVote(id: String): Vote? {
        return voteService.getVote(id)
    }

    fun saveVote(vote: Vote): Vote {
        return voteService.saveVote(vote)
    }


}