import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    println("----start----")

    val sleepReport = demoSleepReport()

    val toJson = Gson().toJson(sleepReport)
    println(toJson)

    println("----end----")
}

private fun demoSleepReport(): SleepReport {
    val currentTimeMillis = System.currentTimeMillis()
    //val simpleDateFormat = SimpleDateFormat("yyyy:MM:dd", Locale.getDefault())

    val date: Long = currentTimeMillis // simpleDateFormat.format(currentTimeMillis) // 本次日期(yyyy:MM:dd)
    val sectionId: Long = currentTimeMillis // 本次记录的唯一ID,(当前为时间戳记录)
    val sleepScore: Int = 69 // 睡眠质量得分
    val sleepTime: SleepTime = SleepTime(
        start = currentTimeMillis, end = currentTimeMillis, total = 12341234234L,
    ) // 睡眠的时间

    val sections: ArrayList<SleepReportSection> = arrayListOf()
    repeat(50) {
        sections.add(
            SleepReportSection(
                start_time = currentTimeMillis, // 开始时间 - 先暂时不用
                end_time = currentTimeMillis, // 结束时间
                stage = 1, // 睡眠状态
                v_acc_dx = 0.833f, // 加速度传感器-x
                v_acc_dy = 0.433f, // 加速度传感器-y
                v_acc_dz = 1.000f, // 加速度传感器-z
                max_decibel = 69f, // 当前周期最大分贝
                min_decibel = 31f, // 当前周期最小分贝
                avg_decibel = 46f, // 当前周期平均分贝
                base_decibel = 25f // 基础分贝参考值
            )
        )
    }
    val sleepStageStatus: SleepStageStatus? = SleepStageStatus(
        awakeTime = 111L,
        deepTime = 222L,
        lightTime = 333L,
        sections = sections
    ) // 深浅睡眠状态总时间

    val bedTime: BedTime = BedTime(
        totalTime = 111L,
    ) //卧床时间
    val sleepDecibel: SleepWholeDecibel = SleepWholeDecibel(
        max = 55f,
        avg = 34f,
        min = 22f,
    ) // 全程的平均分贝

    // {"mapSnoring":{"Snoring":[
    // {"createTime":1684745991594,
    // "duration":19834,
    // "fileName":"1684745991594.mp3",
    // "filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Snoring/1684745991594.mp3",
    // "isPlay":false,"progress":0},
    // {"createTime":1684746803093,"duration":14290,"fileName":"1684746803093.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Snoring/1684746803093.mp3","isPlay":false,"progress":0},{"createTime":1684748372708,"duration":1042,"fileName":"1684748372708.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Snoring/1684748372708.mp3","isPlay":false,"progress":0},{"createTime":1684748434092,"duration":1052,"fileName":"1684748434092.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Snoring/1684748434092.mp3","isPlay":false,"progress":0}],"Speech":[{"createTime":1684745448933,"duration":31318,"fileName":"1684745448933.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745448933.mp3","isPlay":false,"progress":0},{"createTime":1684745481953,"duration":31067,"fileName":"1684745481953.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745481953.mp3","isPlay":false,"progress":0},{"createTime":1684745541945,"duration":31032,"fileName":"1684745541945.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745541945.mp3","isPlay":false,"progress":0},{"createTime":1684745578594,"duration":31030,"fileName":"1684745578594.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745578594.mp3","isPlay":false,"progress":0},{"createTime":1684745609655,"duration":31139,"fileName":"1684745609655.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745609655.mp3","isPlay":false,"progress":0},{"createTime":1684745641873,"duration":31004,"fileName":"1684745641873.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745641873.mp3","isPlay":false,"progress":0},{"createTime":1684745697275,"duration":31067,"fileName":"1684745697275.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745697275.mp3","isPlay":false,"progress":0},{"createTime":1684745740516,"duration":30994,"fileName":"1684745740516.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745740516.mp3","isPlay":false,"progress":0},{"createTime":1684745775952,"duration":31004,"fileName":"1684745775952.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745775952.mp3","isPlay":false,"progress":0},{"createTime":1684745808103,"duration":31003,"fileName":"1684745808103.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745808103.mp3","isPlay":false,"progress":0},{"createTime":1684745840230,"duration":31032,"fileName":"1684745840230.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745840230.mp3","isPlay":false,"progress":0},{"createTime":1684745872380,"duration":31002,"fileName":"1684745872380.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745872380.mp3","isPlay":false,"progress":0},{"createTime":1684745908933,"duration":30742,"fileName":"1684745908933.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745908933.mp3","isPlay":false,"progress":0},{"createTime":1684745939657,"duration":30922,"fileName":"1684745939657.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745939657.mp3","isPlay":false,"progress":0},{"createTime":1684745973926,"duration":17686,"fileName":"1684745973926.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684745973926.mp3","isPlay":false,"progress":0},{"createTime":1684746011476,"duration":30897,"fileName":"1684746011476.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684746011476.mp3","isPlay":false,"progress":0},{"createTime":1684746046794,"duration":30994,"fileName":"1684746046794.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684746046794.mp3","isPlay":false,"progress":0},{"createTime":1684746077826,"duration":30966,"fileName":"1684746077826.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684746077826.mp3","isPlay":false,"progress":0},{"createTime":1684746108774,"duration":31030,"fileName":"1684746108774.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684746108774.mp3","isPlay":false,"progress":0},{"createTime":1684746139825,"duration":30924,"fileName":"1684746139825.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Speech/1684746139825.mp3","isPlay":false,"progress":0}],"Fart":[],"Cough":[{"createTime":1684747900033,"duration":3256,"fileName":"1684747900033.mp3","filePath":"/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Cough/1684747900033.mp3","isPlay":false,"progress":0}]}}
    val sleepRecordMp3File = arrayListOf<SleepRecordMp3File>()
    repeat(20) {
        sleepRecordMp3File.add(
            SleepRecordMp3File(
                name = "1684745991594.mp3",
                path = "/data/user/0/com.starlax.night.sleep/files/V_I_C_E/1684745446784/Snoring/1684745991594.mp3",
                duration = 19834,
                createTime = 1684745991594,
            )
        )
    }
    val map: Map<String, List<SleepRecordMp3File>> = mapOf(
        "Snoring" to sleepRecordMp3File,
        "Speech" to sleepRecordMp3File,
        "Fart" to sleepRecordMp3File,
        "Cough" to sleepRecordMp3File,
    )
    val voices: SleepRecordVoices = SleepRecordVoices(
        map = map,
        max = 55f,
        min = 22f,
        avg = 34f,
    ) // 记录的的声音文件(打呼,梦话,咳嗽,放屁)

    val analysisList: ArrayList<SleepAnalysisSnoring> = arrayListOf()
    repeat(101) {
        analysisList.add(
            SleepAnalysisSnoring(
                55f,
            )
        )
    }
    val snoring: SleepSnoringAnalysis = SleepSnoringAnalysis(
        totalTime = 111L,
        avg = 44f,
        max = 67f,
        min = 33f,
        analysisList = analysisList
    ) // 打呼的分析

    val breath: BreathStop? = BreathStop(
        times = 33,
        max = 34L
    ) //呼吸暂停的次数统计


    val sleepReport = SleepReport(
        date,
        sectionId,
        sleepScore,
        sleepTime,
        sleepStageStatus,
        bedTime,
        sleepDecibel,
        voices,
        snoring,
        breath
    )
    return sleepReport
}