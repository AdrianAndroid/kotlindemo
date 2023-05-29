import java.text.SimpleDateFormat
import java.util.*


fun main(args: Array<String>) {
    println("------hello world!-------")
    // extracted()
    // extracted2()
    // extracted3()
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
    val formatZero = sdf.format(1685233198000L)
    val split = formatZero.split(":")
    val formatZeroFirst = split[0]
    val formatZeroSecond = split[1]

    val formatOther = sdf.format(1685251198000L)
    val split1 = formatOther.split(":")
    val formatOtherFirst = split1[0]
    val formatOtherSecond = split1[1]

    println("formatZero=$formatZero formatOther=$formatOther")
    println(formatZeroFirst.toInt())
    println(formatZeroSecond.toInt())
    println(formatOtherFirst.toInt())
    println(formatOtherSecond.toInt())
}

private fun extracted3() {
    val dateString = "05:24"
    val pattern = "MM:dd"

    // 创建日期格式化对象
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    val sdf = SimpleDateFormat(pattern)

    val format = sdf.format(1685254798000L)
    println("format = $format")

    try {
        // 解析日期字符串为 Date 对象
        val date = dateFormat.parse(dateString)

        // 获取毫秒数
        val milliseconds = date?.time ?: 0

        println("Milliseconds: $milliseconds")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun extracted2() {
    val currentTimestamp = System.currentTimeMillis()

    val calendar = Calendar.getInstance()
    calendar.timeInMillis = currentTimestamp

    // 获取本周的第一天
    calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
    val startDate = calendar.time

    // 获取本周的最后一天
    calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
    val endDate = calendar.time

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    calendar.time = startDate

    while (calendar.time.before(endDate) || calendar.time.equals(endDate)) {
        val currentDate = calendar.time
        val formattedDate = dateFormat.format(currentDate)
        print("currentDate=$currentDate 日期: + $formattedDate  ")
        printDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK))
        // 可根据需要进行其他操作,如获取具体时间等
        calendar.add(Calendar.DAY_OF_WEEK, 1) // 增加一天
    }
}

private fun printDayOfWeek(dayOfWeek: Int) {
    when (dayOfWeek) {
        Calendar.SUNDAY -> println("今天是周日")
        Calendar.MONDAY -> println("今天是周一")
        Calendar.TUESDAY -> println("今天是周二")
        Calendar.WEDNESDAY -> println("今天是周三")
        Calendar.THURSDAY -> println("今天是周四")
        Calendar.FRIDAY -> println("今天是周五")
        Calendar.SATURDAY -> println("今天是周六")
    }
}

private fun extracted() {
    //    val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
//    println("dayOfWeek=$dayOfWeek")
    val calendar = Calendar.getInstance()
    val day1 = Date(1684721998000L) // 周一
        .apply {
            println("day1 = ${this.time}")
            calendar.timeInMillis = this.time
            println(calendar.get(Calendar.DAY_OF_WEEK))
            println()
        }
    val day2 = Date(1684808398000L) // 周二
        .apply {
            println("day2 = ${this.time}")
            calendar.timeInMillis = this.time
            println(calendar.get(Calendar.DAY_OF_WEEK))
            println()
        }
    val day3 = Date(1684894798000L) // 周三
        .apply {
            println("day3 = ${this.time}")
            calendar.timeInMillis = this.time
            println(calendar.get(Calendar.DAY_OF_WEEK))
            println()
        }
    val day4 = Date(1684981198000L) // 周四
        .apply {
            println("day4 = ${this.time}")
            calendar.timeInMillis = this.time
            println(calendar.get(Calendar.DAY_OF_WEEK))
            println()
        }
    val day5 = Date(1685067598000L) // 周五
        .apply {
            println("day5 = ${this.time}")
            calendar.timeInMillis = this.time
            println(calendar.get(Calendar.DAY_OF_WEEK))
            println()
        }
    val day6 = Date(1685153998000L) // 周六
        .apply {
            println("day6 = ${this.time}")
            calendar.timeInMillis = this.time
            println(calendar.get(Calendar.DAY_OF_WEEK))
            println()
        }
    val day7 = Date(1685240398000L) // 周日
        .apply {
            println("day7 = ${this.time}")
            calendar.timeInMillis = this.time
            println(calendar.get(Calendar.DAY_OF_WEEK))
            println()
        }
}