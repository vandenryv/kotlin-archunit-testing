import CommonUtils.newUuid
import org.hexavote.domain.model.Vote
import org.hexavote.domain.outplug.IVoteRepo

@PlugOutComponent
open class VoteRepoHashMap : IVoteRepo {

    private val data = HashMap<String, Vote>()

    override fun saveVote(vote: Vote): Vote {
        val toSave = vote.clone()
        val toSaveId = vote.id ?: newUuid()
        toSave.id = toSaveId
        data[toSaveId] = toSave
        return toSave
    }

    override fun getVote(id: String): Vote? {
        return data[id]?.clone()
    }

    private fun Vote.clone(): Vote = Vote(
        id = this.id,
        name = this.name,
        proposition = this.proposition,
        candidates = this.candidates.toList(),
        ballots = this.ballots.toMutableList(),
        voters = this.voters.toMutableList()
    )
}