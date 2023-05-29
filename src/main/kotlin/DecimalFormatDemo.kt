import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.concurrent.Flow

fun main() {
    println("test DecimalFormat")
    //DecimalFormat mFormat = new DecimalFormat("###,###,###,##0" + b.toString());
    val mFormat = DecimalFormat("###,###,###,##0.00")
    // 指定RoundingMode
    mFormat.roundingMode = RoundingMode.FLOOR
    getArrays().forEach { value ->
        println(mFormat.format(value))
    }
}

fun getArrays(): List<Float> {
    return listOf(
        1.1f,
        1.01f,
        1.001f,
        1.0001f,
        1.000001f
    )
}

class DecimalFormatDemo {
}