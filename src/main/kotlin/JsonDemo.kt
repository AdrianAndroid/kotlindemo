import org.json.JSONObject

fun main(args: Array<String>) {
    val currentDate: Int? = null// 20230506
    val jo = JSONObject()
    if (currentDate != null) {
        jo.put("currentDate", currentDate)
    }
    println(jo)
}

class JsonDemo {
}