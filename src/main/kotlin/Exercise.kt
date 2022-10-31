import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
sealed class Exercise {
    abstract val id: String

    @Serializable
    data class Theory(override val id: String) : Exercise()
}

fun main() {
    val t1 = Exercise.Theory("t1")
    val t1Json = Json.encodeToString(t1)
    println(t1Json)
    println(Json.decodeFromString<Exercise.Theory>(t1Json).toString())
}