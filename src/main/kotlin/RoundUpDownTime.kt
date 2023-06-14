import java.lang.Math.ceil
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.Calendar

fun main(args: Array<String>) {
    println("Hello World!!!!")
    val arrayOf = arrayOf(
        1686017490000L, // 10:11:30
        1686018090000L, // 10:21:30
        1686018690000L, // 10:31:30
        1686019290000L, // 10:41:30
        1686019890000L, // 10:51:30
        1686021090000L, // 11:11:30
        1686021690000L, // 11:21:30
        1686022290000L, // 11:31:30
        1686022890000L, // 11:41:30
        1686023490000L, // 11:51:30
    )
    val sdf = SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒")
    for (l in arrayOf) {
        println("old=${sdf.format(l)} new=${sdf.format(roundHourDownTimestamp(l))}")
    }
    println("------------------------------------------------")
    for (l in arrayOf) {
        println("old=${sdf.format(l)} new=${sdf.format(roundHourUpTimestamp(l))}")
    }

    val startTime = 1686099090000L
    val endTime = 1686185490000


    val startCalendar = Calendar.getInstance()
    startCalendar.timeInMillis = startTime
    val startHour = startCalendar.get(Calendar.HOUR_OF_DAY)
    val endCalendar = Calendar.getInstance()
    endCalendar.timeInMillis = endTime
    val endHour = endCalendar.get(Calendar.HOUR_OF_DAY)

    val totalCount = 7.0
    val hours = Duration.ofMillis(Math.abs(endTime - startTime)).toHours()
    val hourIncrement = ceil(Math.max(Math.abs((hours / totalCount)), 1.0)).toInt()
    println("hourIncrement = $hourIncrement startHour=$startHour  endHour=$endHour  ->${(hours / totalCount)}")
    var count = 0
    while (count <= totalCount) {
        println(startCalendar.get(Calendar.HOUR_OF_DAY))
        startCalendar.add(Calendar.HOUR_OF_DAY, hourIncrement)
        count++
        if (
            startCalendar.timeInMillis > endCalendar.timeInMillis
            && startCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH)
        ) {
            return
        }
    }

}

private const val REFER_TIME_DOWN = 1672502400000L // 2023-01-01 00:00:00

/**
 * 是否是有效的时间戳
 */
fun isValidTimeStamp(referTime: Long?) = referTime != null && referTime > REFER_TIME_DOWN

/**
 * 按小时向上取整
 */
fun roundHourUpTimestamp(timestamp: Long): Long {
    if (!isValidTimeStamp(timestamp)) {
        return timestamp
    }
    val halfHourMillis = 60 * 60 * 1000 // 半小时的毫秒数
    val remainder = timestamp % halfHourMillis
    val roundedTimestamp = if (remainder > 0) {
        timestamp + halfHourMillis - remainder
    } else {
        timestamp
    }
    return roundedTimestamp
}

/**
 * 按小时向下取整
 */
fun roundHourDownTimestamp(timestamp: Long): Long {
    if (!isValidTimeStamp(timestamp)) {
        return timestamp
    }
    val halfHourMillis = 60 * 60 * 1000 // 半小时的毫秒数
    return timestamp / halfHourMillis * halfHourMillis
}

class RoundUpDownTime {
}