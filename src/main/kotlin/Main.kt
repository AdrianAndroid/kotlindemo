import java.util.Collections
import java.util.Comparator

val arrayList = arrayListOf<Long>(
    1683854290203,
    1683854290213,
    1683854290223,
    1683854290233,
    1683854290243,
    1683854290253,
    1683854290263,
    1683854290273,
    1683854290283,
    1683854290293,
    1683854290303,
    1683854290313,
    1683854290323,
    1683854290333,
    1683854290343,
    1683854290353,
    1683854290363,
    1683854290373,
    1683854290383,
    1683854290393,
    1683854290403,
    1683854290413,
    1683854290423,
    1683854290433,
    1683854290443,
    1683854290453,
    1683854290463,
    1683854290473,
    1683854290483,
    1683854290493,
    1683854290503,
    1683854290513,
    1683854290523,
    1683854290533,
    1683854290543,
    1683854290553,
    1683854290563,
    1683854290573,
    1683854290583,
    1683854290593,
    1683854290603,
    1683854290613,
    1683854290623,
    1683854290633,
    1683854290643,
    1683854290653,
    1683854290663,
    1683854290673,
    1683854290683,
    1683854290693,
    1683854290703,
    1683854290713,
    1683854290723,
    1683854290733,
    1683854290743,
    1683854290753,
    1683854290763,
    1683854290773,
    1683854290783,
    1683854290793,
    1683854290803,
    1683854290813,
    1683854290823,
    1683854290833,
    1683854290843,
    1683854290853,
    1683854290863,
    1683854290873,
    1683854290883,
    1683854290893,
    1683854290903,
    1683854290913,
    1683854290923,
    1683854290933,
    1683854290943,
    1683854290953,
    1683854290963,
    1683854290973,
    1683854290983,
    1683854290993,
    1683854291003,
    1683854291013,
    1683854291023,
    1683854291033,
    1683854291043,
    1683854291053,
    1683854291063,
    1683854291073,
    1683854291083,
    1683854291093,
    1683854291103,
    1683854291113,
    1683854291123,
    1683854291133,
    1683854291143,
    1683854291153,
    1683854291163,
    1683854291173,
    1683854291183,
    1683854291193
)

val array222 = arrayListOf<Long>(
    1683854290001L,
    1683854290002L,
    1683854290005L,
    1683854290003L,
    1683854290007L,
    1683854290004L,
    1683854290006L,
    1683854290008L,
    1683854290009L,
    1683854290010L,
    1683854290011L,
)

fun main(args: Array<String>) {
    println("Hello World!")

//    val listOf = arrayListOf<Float>()
//    repeat(100) {
//        val decibel = (30..90).random().toFloat()
//        listOf.add(decibel)
//    }

    array222.forEach {
        println(it)
    }
    val newList = ComparatorUtils.compareListAscend(array222) { it }
    println("=============")
    newList.forEach {
        println(it)
    }

//    println(listOf)
    //(30..90).random().toFloat()

    //extracted2()
    // extracted()
}

private fun extracted2() {
    val startTime = 1683854290203L
    val sliceNum = 10

    val displayList = arrayListOf<Long>()
    repeat(100) { index ->
        displayList.add(startTime + sliceNum * index)
    }
    println("displayList -> $displayList")
    for (displayNum in arrayList) {
        print(displayNum)
    }
    println()

    val needList = arrayListOf<Long>(
        1683854290203,
        1683854290244,
        1683854290304,
        1683854290314,
        1683854290394,
        1683854290414,
        1683854290614,
        1683854290634,
        1683854290844,
        1683854290854,
        1683854290864,
        1683854290934
    )
    if (needList.isEmpty()) {
        return
    }
    val comparator = object : Comparator<Long> {
        override fun compare(o1: Long?, o2: Long?): Int {
            o1 ?: return 1 // 要是为空,就放在最后边
            o2 ?: return 1 // 要是为空,就放在最后边
            return o1.compareTo(o2)
        }
    }
    // 不能为空
    val sortIterator = NextIterator(needList.sortedWith(comparator))
    var currentTime = startTime
    val resultList = mutableListOf<Int>()
    while (resultList.size <= 100) {
        val currentNext = sortIterator.currentNext()
        if (currentNext != null && currentNext.isLessThan(currentTime)) {
            resultList.add(generateRandomDecibel())
            resultList.add(0)
            sortIterator.next()
        } else {
            resultList.add(0)
        }
        currentTime += sliceNum
    }
    println("resultList -> $resultList")
}

class NextIterator<T>(sortedList: List<T>) {
    private val iterator: Iterator<T>
    private var currentNext: T? = null
    private var hasNext: Boolean = false

    init {
        iterator = sortedList.iterator()
        currentNext = if (iterator.hasNext()) iterator.next() else null
    }

    fun hasCurrentNext() = currentNext != null

    fun currentNext() = currentNext

    fun next(): T? {
        currentNext = if (iterator.hasNext()) {
            iterator.next()
        } else {
            null
        }
        return currentNext
    }
}

fun generateRandomDecibel(): Int {
    return (30..90).random()
}

private fun extracted() {
    val resultList = listOf(
        1683854290200,
        1683854290205,
        1683854290206,
    )

    val listOf = listOf(
        1683854290201,
        1683854290200,
        1683854290203,
        1683854290202,
        1683854290204,
        1683854290208,
        1683854290209,
        1683854290207,
    )

    fun isLessThan(compareOne: Long, compareTwo: Long): Boolean {
        return compareOne.compareTo(compareTwo) == -1
    }

    val compare1 = 1683854290200L
    val compare2 = 1683854290206L
    println("1683854290200 < 1683854290206 = ${isLessThan(compare1, compare2)}")

    val comparator = object : Comparator<Long> {
        override fun compare(o1: Long?, o2: Long?): Int {
            o1 ?: return 1 // 要是为空,就放在最后边
            o2 ?: return 1 // 要是为空,就放在最后边
            return o1.compareTo(o2)
        }
    }
    val sortResultList = resultList.sortedWith(comparator)
    val sortListOf = listOf.sortedWith(comparator)

    val hopeList = mutableListOf<Long>()
    val iterator = sortResultList.iterator()
    for (time in sortListOf) {
        if (iterator.hasNext()) {
            val next = iterator.next()
            val compareResult = time.compareTo(next)
            if (isCompareEquals(compareResult)) {
                hopeList.add(time)
            } else if (isCompareLess(compareResult)) {
                hopeList.add(time)
                hopeList.add(next)
            } else if (isCompareGreat(compareResult)) {
                hopeList.add(next)
                hopeList.add(time)
            }
        } else {
            hopeList.add(time)
        }
    }
    println("hopeList -> ${hopeList.sorted()}")


    val sorted = listOf.sorted()
    for (sortL in sorted) {
        println(sortL)
    }
    val sortedWith = listOf.sortedWith(comparator)
    println(sortedWith)
}

fun isCompareLess(compareResult: Int): Boolean = compareResult == -1

fun isCompareGreat(compareResult: Int): Boolean = compareResult == 1

fun isCompareEquals(compareResult: Int): Boolean = compareResult == 0


fun Long.isEqualsTo(other: Long): Boolean {
    return this == other
}

fun Long.isLessThan(other: Long): Boolean {
    return this.compareTo(other) == -1
}