package org.hexavote.domain.model

data class Vote(
    var id: String?,
    var name: String,
    var proposition: String,
    val candidates: List<Candidate>,
    val ballots: MutableList<Ballot> = arrayListOf(),
    val voters: MutableList<Voter> = arrayListOf(),
) {

}