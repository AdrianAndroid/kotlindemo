import com.google.gson.Gson
import com.google.gson.JsonObject

data class LongArrayDemo(
    val id: Int,
    val longArray: LongArray = longArrayOf(0L, 0L, 0L)
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LongArrayDemo

        if (id != other.id) return false
        if (!longArray.contentEquals(other.longArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + longArray.contentHashCode()
        return result
    }
}

fun main() {
    val gson = Gson()
    val longArrayDemo = LongArrayDemo(0)
    println(gson.toJson(longArrayDemo))
}