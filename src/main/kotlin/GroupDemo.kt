fun main() {
    val sleepDataList = listOf(
        SleepData("Monday", 85),
        SleepData("Tuesday", 90),

        SleepData("Wednesday", 0),

        SleepData("Thursday", 0),

        SleepData("Friday", 75),
        SleepData("Saturday", 80),
        
        SleepData("Sunday", 0)
    )

    val groupedSleepData = mutableListOf<List<SleepData>>()
    val currentGroup = mutableListOf<SleepData>()

    for (sleepData in sleepDataList) {
        if (sleepData.sleepScore == 0) {
            if (currentGroup.isNotEmpty()) {
                groupedSleepData.add(currentGroup.toList())
                currentGroup.clear()
            }
            currentGroup.add(sleepData)
            groupedSleepData.add(currentGroup.toList())
            currentGroup.clear()
        } else {
            currentGroup.add(sleepData)
        }
    }

    if (currentGroup.isNotEmpty()) {
        groupedSleepData.add(currentGroup.toList())
    }

    for (groupedSleepDatum in groupedSleepData) {
        println(groupedSleepDatum)
    }
}

data class SleepData(
    val title: String,
    val sleepScore: Int
)

class GroupDemo {
}