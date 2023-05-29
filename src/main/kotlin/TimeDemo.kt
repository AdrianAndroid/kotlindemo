import java.util.Calendar

fun main(args: Array<String>) {
    val instance = Calendar.getInstance()
    instance.timeInMillis = 0L
    println(instance.get(Calendar.HOUR_OF_DAY))
}

class TimeDemo {


}