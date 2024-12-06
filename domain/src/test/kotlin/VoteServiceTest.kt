import CommonUtils.newUuid
import TestUtils.getRandomString
import org.hexavote.domain.VoteService
import org.hexavote.domain.model.Ballot
import org.hexavote.domain.model.Candidate
import org.hexavote.domain.model.Vote
import org.hexavote.domain.outplug.IVoteRepo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock

@ExtendWith()
class VoteServiceTest {
    val repo = mock<IVoteRepo>()

    val voteService = VoteService(repo)

    @Test
    fun computeResult() {
        val voteId = newUuid()
        val candidate1 = Candidate(newUuid(), "01-" + getRandomString(10))
        val candidate2 = Candidate(newUuid(), "02-" + getRandomString(10))
        val candidate3 = Candidate(newUuid(), "03-" + getRandomString(10))
        val candidate4 = Candidate(newUuid(), "04-" + getRandomString(10))

        val vote = Vote(
            id = newUuid(),
            name = getRandomString(10),
            proposition = getRandomString(150),
            candidates = listOf(candidate1, candidate2, candidate3, candidate4),
            ballots = mutableListOf(
                Ballot(listOf(candidate1, candidate2, candidate3, candidate4)),
                Ballot(listOf(candidate1, candidate2, candidate3, candidate4)),
                Ballot(listOf(candidate2, candidate1, candidate3, candidate4)),
                Ballot(listOf(candidate3, candidate2, candidate1, candidate4)),
                Ballot(listOf(candidate1, candidate2, candidate3, candidate4)),
                Ballot(listOf(candidate3, candidate1, candidate2, candidate4)),
                Ballot(listOf(candidate4, candidate1, candidate2, candidate3)),
                Ballot(listOf(candidate4, candidate1, candidate2, candidate3)),
            ),
            voters = mutableListOf()
        )

        doReturn(vote).`when`(repo).getVote(voteId)

        val result = voteService.computeResult(voteId)

        assert(result == listOf(candidate1, candidate4, candidate3, candidate2))

    }


}