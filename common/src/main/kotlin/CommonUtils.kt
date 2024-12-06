import java.util.*

object CommonUtils {
    fun newUuid(): String = UUID.randomUUID()?.toString() ?: throw Exception("Uuid not generated")
}