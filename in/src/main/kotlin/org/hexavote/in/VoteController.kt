package org.hexavote.`in`

import common.TestUtils.getRandomString
import org.hexavote.domain.model.Vote
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

open class VoteController(
    private val voteAdapter: VoteAdapter
) {


    @GetMapping("/{id}")
    fun getVotes(@PathVariable id: String): Vote? {
        return voteAdapter.getVote(id)
    }

    @PostMapping("/newrandom")
    fun genRandomVote(): Vote {
        return voteAdapter.saveVote(
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