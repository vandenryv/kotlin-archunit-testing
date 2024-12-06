package org.hexavote.domain.errors

sealed class VoteServiceError : Throwable() {

}

data class VoteNotFoundError(val id: String) : VoteServiceError()