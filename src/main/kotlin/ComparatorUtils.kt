object ComparatorUtils {

    /**
     * Compares this value with the specified value for order.
     * Returns zero if this value is equal to the specified other value,
     * a negative number if it's less than other,
     * or a positive number if it's greater than other.
     */
    private fun compareLongAscend(l1: Long, l2: Long): Int {
        return l1.compareTo(l2)
    }

    private fun compareDescend(l1: Long, l2: Long): Int {
        return l2.compareTo(l1)
    }

    private fun <T> compareAscend(o1: T, o2: T, action: ((T) -> Long)): Int {
        val l1 = action.invoke(o1)
        val l2 = action.invoke(o2)
        return compareLongAscend(l1, l2)
    }

    fun <T> compareListAscend(list: List<T>, action: ((T) -> Long)): List<T> {
        return list.sortedWith { o1, o2 ->
            compareAscend(o1, o2, action)
        }
    }
}