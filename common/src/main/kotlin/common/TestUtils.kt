package common

object TestUtils {
    private val ALLOWED_CARD = ('A'..'Z') + ('a'..'z') + ('0'..'9')

    fun getRandomString(length: Int): String {
        return (1..length)
            .map { ALLOWED_CARD.random() }
            .joinToString("")
    }

}