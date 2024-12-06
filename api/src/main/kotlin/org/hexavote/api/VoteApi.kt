package org.hexavote.api

import TestUtils.getRandomString
import org.hexavote.domain.inplug.IVoteService
import org.hexavote.domain.model.Vote
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

open class VoteApi(
    private val voteService: IVoteService
) {


    @GetMapping("/{id}")
    fun getVotes(@PathVariable id: String): Vote? {
        return voteService.getVote(id)
    }

    @PostMapping("/newrandom")
    fun genRandomVote(): Vote {
        return voteService.saveVote(
            Vote(
                id = null,
                name = "random-" + getRandomString(10),
                proposition = getRandomString(100),
                candidates = ArrayList(),
                ballots = ArrayList(),
                voters = ArrayList(),
            )
        )
    }
}