import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters
import java.time.temporal.WeekFields
import java.util.*
import kotlin.math.ceil

fun main() {
    println("Hello World!")
    // print111()
//    print222()
//    print333()
//    print444()
//    print555()
//    print666()
//    print777()
//    print888()
//    print999()
//    print100()
    print101()
}

fun print101() {
    val calendar = Calendar.getInstance(Locale.ENGLISH)
    calendar.timeInMillis = System.currentTimeMillis()
    val weekInMonth = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH)
    println("weekInMonth=${weekInMonth}")
}

fun print100() {
    val yearMonth = YearMonth.of(12, 8)
    val weekFields = WeekFields.of(Locale.getDefault())
    val firstDayOfMonth = yearMonth.atDay(1)
    val lastDayOfMonth = yearMonth.atEndOfMonth()
    val firstWeek = firstDayOfMonth.get(weekFields.weekOfMonth())
    val lastWeek = lastDayOfMonth.get(weekFields.weekOfMonth())

    val totalWeeks = lastWeek - firstWeek + 1
    println("Total Weeks in Current Month: $totalWeeks")
}

fun print999() {
//    val year = 2023
//    val month = 6
//    val targetWeek = 1 // 假设要获取本月的第二周
    val calendar = Calendar.getInstance()
    val mmddFormatter = DateTimeFormatter.ofPattern("M/dd")
    calendar.timeInMillis = 1701993600000L
    val weeksInMonth = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH)
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1
    println("weeksInMonth=$weeksInMonth year=$year month=$month")

    for (targetWeek in 1..weeksInMonth) {
        val firstDayOfMonth = LocalDate.of(year, month, 1)
        val firstDayOfWeek = firstDayOfMonth.with(TemporalAdjusters.previous(DayOfWeek.MONDAY))
        val weekStart: LocalDate = firstDayOfWeek.plusWeeks((targetWeek - 1).toLong())
        val weekEnd = weekStart.plusDays(6)

        val start = weekStart.format(mmddFormatter)
        val end = weekEnd.format(mmddFormatter)
        //println("$weekStart  --------> $weekEnd")
        println("$start  ------ $end")
    }
}

fun print888() {
    val ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault())
    println(ofInstant.year)
}

fun print777() {
    val listOf = listOf<Int>(2024, 2023, 2025)
    val list = listOf.sorted()
    println(list)
}

fun print666() {
    val ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault())
    println(ofInstant.monthValue)
}

fun print555() {
    for (i in 1..12) {
        println(i)
    }
}

fun print444() {
    //val time = 202301
    val array = arrayOf(
        202301,
        202302,
        202303,
        202304,
        202305,
        202306,
        202307,
        202308,
        202309,
        202310,
        202311,
        202312,
    ).forEach { time ->
        println(time % 100)
    }
}

fun print333() {
    val calendar = Calendar.getInstance(Locale.CHINESE)
    // 设置日历为当前月份的第一天
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    // 获取当前月份的第一天是星期几
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    // 设置要获取的周数
    val targetWeek = 2  // 假设要获取第二周的起始日期
    // 计算目标周的起始日期
    val startDay = 1 + (targetWeek - 1) * 7 - (firstDayOfWeek - 1)
    // 将日历设置为目标周的起始日期
    calendar.set(Calendar.DAY_OF_MONTH, startDay)
    // 获取目标周的起始日期
    val startDate = calendar.time
    println("Week Start Date: $startDate")
}

fun print222() {
    val calendar = Calendar.getInstance()
    // 获取当前月份的最大天数
    val maxDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    // 设置日历为当前月份的第一天
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    // 获取当前月份的第一天是星期几
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    // 计算本月的周数
    val weeksInMonth = ceil((maxDaysInMonth + firstDayOfWeek - 1) / 7.0).toInt()
    // 打印每个周的起始范围
    for (week in 1..weeksInMonth) {
        // 计算每周的起始日期
        val startDay = 1 + (week - 1) * 7 - (firstDayOfWeek - 1)
        calendar.set(Calendar.DAY_OF_MONTH, startDay)
        println("---->${calendar.time}")

        // 计算每周的结束日期
        val endDay = minOf(startDay + 6, maxDaysInMonth)
        calendar.set(Calendar.DAY_OF_MONTH, endDay)
        println("---->${calendar.time}")

        println("Week $week: $startDay - $endDay")
        println(">>>>>>>>>>>>>>>>>======<<<<<<<<<<<<<<<<<<<<")
    }
}

fun print111() {
    val sdfEEEMMdd by lazy { SimpleDateFormat("EEE MM/dd", Locale.ENGLISH) }
    val dayInterval = 86400000L
    val startTime = 1685588616000L
    val calendar = Calendar.getInstance()
    repeat(32) { index ->
        //println(Date(startTime * index))
        val currentTime = startTime + index * dayInterval
        calendar.timeInMillis = currentTime
        println("weekOfMonth=${calendar.get(Calendar.WEEK_OF_MONTH)} ${sdfEEEMMdd.format(currentTime)}")
    }
}


class MonthEveryWeekDemo {
}