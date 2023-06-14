import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

fun main(args: Array<String>) {
    println("hello world!")
    val timestamp = changeIntTimeToTimestamp(20230608)
    println(timestamp)
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = timestamp
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    println("$year $month $day")
    println("${year*10000 + month * 100 + day}")

    val sdfEeeMmDd = SimpleDateFormat("EEE\nMM/dd", Locale.ENGLISH)
    println(sdfEeeMmDd.format(Date()).uppercase(Locale.ENGLISH))
}

private val yyyyMMddFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")

/**
 * 将20230524转换成时间戳
 */
fun changeIntTimeToTimestamp(intTime: Int): Long {
    kotlin.runCatching {
        val dateTimeStr = intTime.toString()
        if (dateTimeStr.length != 8) {
            return 0L
        }
        val date = LocalDate.parse(dateTimeStr, yyyyMMddFormatter)
        return date.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()
    }
    return 0L
}

class IntDateChange {
}