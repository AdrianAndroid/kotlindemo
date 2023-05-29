import com.google.gson.Gson

fun main(args: Array<String>) {
    println("test!!!")

    //睡眠质量评分：Sleep Quality Score 横坐标为日期，纵坐标为每日评分数，纵坐标只展示5个数值；折线图
    val quality: TrendSleepQualityScore = TrendSleepQualityScore(list = listOf(
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55)
    ))

    //睡觉时间 睡觉时间： Bedtime 横坐标为日期，纵坐标为每日开始睡觉的时间，纵坐标只展示5个数值；折线图
    val bed: TrendBedTime = TrendBedTime(list = listOf(
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis())
    ))

    //起床时间：Wake-up Time 横坐标为日期，纵坐标为每日结束睡眠的时间，纵坐标只展示5个数值；折线图
    val wake: TrendWakeTime = TrendWakeTime(list = listOf(
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis()),
        TrendData(System.currentTimeMillis(), System.currentTimeMillis())
    ))

    //深睡眠时长：Deep Sleep 横坐标为日期，纵坐标为每日深度睡眠的时长，纵坐标只展示5个数值；柱状图
    val deep: TrendDeepSleep = TrendDeepSleep(list = listOf(
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L)
    ))

    //浅睡眠时长：Light Sleep 横坐标为日期，纵坐标为每日浅度睡眠的时长，纵坐标只展示5个数值；柱状图
    val light: TrendLightSleep = TrendLightSleep(list = listOf(
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L)
    ))

    //清醒时长：Wakefulness 横坐标为日期，纵坐标为每日清醒的时长，纵坐标只展示5个数值；柱状图
    val awake: TrendAwakeSleep = TrendAwakeSleep(list = listOf(
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L),
        TrendData(System.currentTimeMillis(), 1112L)
    ))

    //打鼾时长：Snoring Duration 横坐标为日期纵坐标为每日打鼾总时长，纵坐标只展示5个数值；柱状图
    val snoringDuration: TrendSnoringDuration = TrendSnoringDuration(list = listOf(
        TrendData(System.currentTimeMillis(), 1200L),
        TrendData(System.currentTimeMillis(), 1200L),
        TrendData(System.currentTimeMillis(), 1200L),
        TrendData(System.currentTimeMillis(), 1200L),
        TrendData(System.currentTimeMillis(), 1200L)
    ))

    //鼾声平均分贝：Average Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的平均分贝，纵坐标只展示5个数值；柱状图
    val avgSnoring: TrendAverageSnoringDecibel = TrendAverageSnoringDecibel(list = listOf(
        TrendData(System.currentTimeMillis(), 33),
        TrendData(System.currentTimeMillis(), 44),
        TrendData(System.currentTimeMillis(), 33),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 66)
    ))

    //鼾声最大分贝：Maximum Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的最大分贝，纵坐标只展示5个数值；柱状图
    val maxSnoring: TrendMaximumSnoringDecibel = TrendMaximumSnoringDecibel(list = listOf(
        TrendData(System.currentTimeMillis(), 33),
        TrendData(System.currentTimeMillis(), 44),
        TrendData(System.currentTimeMillis(), 33),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 66)
    ))

    //呼吸暂停频率：Apnea frequency 横坐标为日期，纵坐标为每日以小时为单位呼吸暂停的次数，纵坐标只展示5个数值；折线图
    val apnea: TrendApneaFrequency = TrendApneaFrequency(list = listOf(
        TrendData(System.currentTimeMillis(), 5),
        TrendData(System.currentTimeMillis(), 39),
        TrendData(System.currentTimeMillis(), 20),
        TrendData(System.currentTimeMillis(), 11),
        TrendData(System.currentTimeMillis(), 6),
    ))

    //呼吸暂停最大时长：Maximum Apnea Duration 横坐标为日期，纵坐标为每日呼吸暂停最大时长，纵坐标只展示5个数值；柱状图
    val maxApnea: TrendMaximumApneaDuration = TrendMaximumApneaDuration(list = listOf(
        TrendData(System.currentTimeMillis(), 23300),
        TrendData(System.currentTimeMillis(), 23300),
        TrendData(System.currentTimeMillis(), 23300),
        TrendData(System.currentTimeMillis(), 23300),
        TrendData(System.currentTimeMillis(), 23300)
    ))

    //平均噪音：Average Noise横坐标为日期，纵坐标为每日环境噪音平均分贝，纵坐标只展示5个数值；柱状图
    val avgNoise: TrendAverageNoise = TrendAverageNoise(list = listOf(
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55),
        TrendData(System.currentTimeMillis(), 55)
    ))

    //最大噪音：Maximum Noise横坐标为日期，纵坐标为每日环境噪音的最大分贝，纵坐标只展示5个数值；柱状图
    val maxNoise: TrendMaximumNoise = TrendMaximumNoise(list = listOf(
        TrendData(System.currentTimeMillis(), 66),
        TrendData(System.currentTimeMillis(), 66),
        TrendData(System.currentTimeMillis(), 66),
        TrendData(System.currentTimeMillis(), 66),
        TrendData(System.currentTimeMillis(), 66)
    ))


    val sleepTrend = SleepTrend(
        //睡眠质量评分：Sleep Quality Score 横坐标为日期，纵坐标为每日评分数，纵坐标只展示5个数值；折线图
        quality = quality,
        //睡觉时间 睡觉时间： Bedtime 横坐标为日期，纵坐标为每日开始睡觉的时间，纵坐标只展示5个数值；折线图
        bed = bed,
        //起床时间：Wake-up Time 横坐标为日期，纵坐标为每日结束睡眠的时间，纵坐标只展示5个数值；折线图
        wake = wake,
        //深睡眠时长：Deep Sleep 横坐标为日期，纵坐标为每日深度睡眠的时长，纵坐标只展示5个数值；柱状图
        deep = deep,
        //浅睡眠时长：Light Sleep 横坐标为日期，纵坐标为每日浅度睡眠的时长，纵坐标只展示5个数值；柱状图
        light = light,
        //清醒时长：Wakefulness 横坐标为日期，纵坐标为每日清醒的时长，纵坐标只展示5个数值；柱状图
        awake = awake,
        //打鼾时长：Snoring Duration 横坐标为日期纵坐标为每日打鼾总时长，纵坐标只展示5个数值；柱状图
        snoringDuration = snoringDuration,
        //鼾声平均分贝：Average Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的平均分贝，纵坐标只展示5个数值；柱状图
        avgSnoring = avgSnoring,
        //鼾声最大分贝：Maximum Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的最大分贝，纵坐标只展示5个数值；柱状图
        maxSnoring = maxSnoring,
        //呼吸暂停频率：Apnea frequency 横坐标为日期，纵坐标为每日以小时为单位呼吸暂停的次数，纵坐标只展示5个数值；折线图
        apnea = apnea,
        //呼吸暂停最大时长：Maximum Apnea Duration 横坐标为日期，纵坐标为每日呼吸暂停最大时长，纵坐标只展示5个数值；柱状图
        maxApnea = maxApnea,
        //平均噪音：Average Noise横坐标为日期，纵坐标为每日环境噪音平均分贝，纵坐标只展示5个数值；柱状图
        avgNoise = avgNoise,
        //最大噪音：Maximum Noise横坐标为日期，纵坐标为每日环境噪音的最大分贝，纵坐标只展示5个数值；柱状图
        maxNoise = maxNoise,
    )
    println(Gson().toJson(sleepTrend))
}

/**
 * 获取趋势的数据, 本期需求每个都需要前5天的数据
 */
data class SleepTrend(
    //睡眠质量评分：Sleep Quality Score 横坐标为日期，纵坐标为每日评分数，纵坐标只展示5个数值；折线图
    val quality: TrendSleepQualityScore? = null,
    //睡觉时间 睡觉时间： Bedtime 横坐标为日期，纵坐标为每日开始睡觉的时间，纵坐标只展示5个数值；折线图
    val bed: TrendBedTime? = null,
    //起床时间：Wake-up Time 横坐标为日期，纵坐标为每日结束睡眠的时间，纵坐标只展示5个数值；折线图
    val wake: TrendWakeTime? = null,
    //深睡眠时长：Deep Sleep 横坐标为日期，纵坐标为每日深度睡眠的时长，纵坐标只展示5个数值；柱状图
    val deep: TrendDeepSleep? = null,
    //浅睡眠时长：Light Sleep 横坐标为日期，纵坐标为每日浅度睡眠的时长，纵坐标只展示5个数值；柱状图
    val light: TrendLightSleep? = null,
    //清醒时长：Wakefulness 横坐标为日期，纵坐标为每日清醒的时长，纵坐标只展示5个数值；柱状图
    val awake: TrendAwakeSleep? = null,
    //打鼾时长：Snoring Duration 横坐标为日期纵坐标为每日打鼾总时长，纵坐标只展示5个数值；柱状图
    val snoringDuration: TrendSnoringDuration? = null,
    //鼾声平均分贝：Average Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的平均分贝，纵坐标只展示5个数值；柱状图
    val avgSnoring: TrendAverageSnoringDecibel? = null,
    //鼾声最大分贝：Maximum Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的最大分贝，纵坐标只展示5个数值；柱状图
    val maxSnoring: TrendMaximumSnoringDecibel? = null,
    //呼吸暂停频率：Apnea frequency 横坐标为日期，纵坐标为每日以小时为单位呼吸暂停的次数，纵坐标只展示5个数值；折线图
    val apnea: TrendApneaFrequency? = null,
    //呼吸暂停最大时长：Maximum Apnea Duration 横坐标为日期，纵坐标为每日呼吸暂停最大时长，纵坐标只展示5个数值；柱状图
    val maxApnea: TrendMaximumApneaDuration? = null,
    //平均噪音：Average Noise横坐标为日期，纵坐标为每日环境噪音平均分贝，纵坐标只展示5个数值；柱状图
    val avgNoise: TrendAverageNoise? = null,
    //最大噪音：Maximum Noise横坐标为日期，纵坐标为每日环境噪音的最大分贝，纵坐标只展示5个数值；柱状图
    val maxNoise: TrendMaximumNoise? = null,
)

data class TrendData(
    val date: Long? = 0, // 日期(时间戳)
    val value: Long? = 0, // 值
)

//睡眠质量评分：Sleep Quality Score 横坐标为日期，纵坐标为每日评分数，纵坐标只展示5个数值；折线图
data class TrendSleepQualityScore(val list: List<TrendData>? = null)

//睡觉时间 睡觉时间： Bedtime 横坐标为日期，纵坐标为每日开始睡觉的时间，纵坐标只展示5个数值；折线图
data class TrendBedTime(val list: List<TrendData>? = null)

//起床时间：Wake-up Time 横坐标为日期，纵坐标为每日结束睡眠的时间，纵坐标只展示5个数值；折线图
data class TrendWakeTime(val list: List<TrendData>? = null)

//深睡眠时长：Deep Sleep 横坐标为日期，纵坐标为每日深度睡眠的时长，纵坐标只展示5个数值；柱状图
data class TrendDeepSleep(val list: List<TrendData>? = null)

//浅睡眠时长：Light Sleep 横坐标为日期，纵坐标为每日浅度睡眠的时长，纵坐标只展示5个数值；柱状图
data class TrendLightSleep(val list: List<TrendData>? = null)

//清醒时长：Wakefulness 横坐标为日期，纵坐标为每日清醒的时长，纵坐标只展示5个数值；柱状图
data class TrendAwakeSleep(val list: List<TrendData>? = null)

//打鼾时长：Snoring Duration 横坐标为日期纵坐标为每日打鼾总时长，纵坐标只展示5个数值；柱状图
data class TrendSnoringDuration(val list: List<TrendData>? = null)

//鼾声平均分贝：Average Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的平均分贝，纵坐标只展示5个数值；柱状图
data class TrendAverageSnoringDecibel(val list: List<TrendData>? = null)

//鼾声最大分贝：Maximum Snoring Decibel Level 横坐标为日期，纵坐标为每日打鼾的最大分贝，纵坐标只展示5个数值；柱状图
data class TrendMaximumSnoringDecibel(val list: List<TrendData>? = null)

//呼吸暂停频率：Apnea frequency 横坐标为日期，纵坐标为每日以小时为单位呼吸暂停的次数，纵坐标只展示5个数值；折线图
data class TrendApneaFrequency(val list: List<TrendData>? = null)

//呼吸暂停最大时长：Maximum Apnea Duration 横坐标为日期，纵坐标为每日呼吸暂停最大时长，纵坐标只展示5个数值；柱状图
data class TrendMaximumApneaDuration(val list: List<TrendData>? = null)

//平均噪音：Average Noise横坐标为日期，纵坐标为每日环境噪音平均分贝，纵坐标只展示5个数值；柱状图
data class TrendAverageNoise(val list: List<TrendData>? = null)

//最大噪音：Maximum Noise横坐标为日期，纵坐标为每日环境噪音的最大分贝，纵坐标只展示5个数值；柱状图
data class TrendMaximumNoise(val list: List<TrendData>? = null)

