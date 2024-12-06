import CommonUtils.newUuid
import TestUtils.getRandomString
import org.hexavote.domain.model.Candidate
import org.hexavote.domain.model.Vote
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VoteRepoHashMapTest {

    val voteRepoHashMap = VoteRepoHashMap()

    @Test
    fun getSaveWithId() {
        val vote = Vote(
            id = newUuid(),
            name = getRandomString(10),
            proposition = getRandomString(99),
            candidates = listOf(
                Candidate(newUuid(), getRandomString(10)),
                Candidate(newUuid(), getRandomString(10)),
                Candidate(newUuid(), getRandomString(10))
            )
        )

        voteRepoHashMap.saveVote(vote)

        val retrievedVote = voteRepoHashMap.getVote(vote.id ?: "")

        assertEquals(vote, retrievedVote)


    }


    @Test
    fun getSaveWithoutId() {
        val vote = Vote(
            id = null,
            name = getRandomString(10),
            proposition = getRandomString(99),
            candidates = listOf(
                Candidate(newUuid(), getRandomString(10)),
                Candidate(newUuid(), getRandomString(10)),
                Candidate(newUuid(), getRandomString(10))
            )
        )

        val savedVote = voteRepoHashMap.saveVote(vote)

        val retrievedVote = voteRepoHashMap.getVote(savedVote.id ?: "")

        assertEquals(vote.name, retrievedVote?.name)


    }
}