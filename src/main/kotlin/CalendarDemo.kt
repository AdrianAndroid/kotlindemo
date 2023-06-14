import java.awt.PageAttributes.MediaType
import java.io.File
import java.util.*


class CalendarDemo {
}

fun main(args: Array<String>) {
    println("Hello World!")
    val instance = Calendar.getInstance()
    instance.timeInMillis = System.currentTimeMillis()
    val year = instance.get(Calendar.YEAR)
    val hour = instance.get(Calendar.HOUR_OF_DAY)
    val minute = instance.get(Calendar.MINUTE)
    val latest = year * 10000 + hour * 100 + minute
    println("year-$year hour-$hour minute-$minute latest-$latest")
}

fun test() {

}