package common

import java.util.*


object CommonUtils {
    @JvmStatic
    fun newUuid(): String = UUID.randomUUID()?.toString() ?: throw Exception("Uuid not generated")
}