import java.lang.Math.abs
import java.lang.Math.ceil
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*

fun main() {
    calculate()
//    println("------------------------")
//    val timestamp = System.currentTimeMillis()
//    val sdf = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
//    val date = Date(timestamp)
//    println(sdf.format(date))
}

fun calculate() {
    val startHour = 1
    val endHour = 8
    val totalCount = 6.0
    val hourIncrement = 1

    val mutableListOf = mutableListOf<String>()
    while (mutableListOf.size < 6) {
        mutableListOf.add("1")
    }
    println(mutableListOf)
}

class TimeUtilsDemo {
}