/**
 * 睡眠报告页面
 */
data class SleepReport(
    var date: Long? = null, // 本次日期(yyyy:MM:dd)
    var sectionId: Long? = -1, // 本次记录的唯一ID,(当前为时间戳记录)
    var sleepScore: Int? = 0, // 睡眠质量得分
    var sleepTime: SleepTime? = null, // 睡眠的时间
    var sleepStageStatus: SleepStageStatus? = null, // 深浅睡眠状态总时间
    var bedTime: BedTime? = null, //卧床时间
    var sleepDecibel: SleepWholeDecibel? = null, // 全程的平均分贝
    var voices: SleepRecordVoices? = null, // 记录的的声音文件(打呼,梦话,咳嗽,放屁)
    var snoring: SleepSnoringAnalysis? = null, // 打呼的分析
    var breath: BreathStop? = null, //呼吸暂停的次数统计
)

/**
 * 这个睡眠时间记录的分贝
 */
data class SleepWholeDecibel(
    var max: Float? = 0f, // 最大分贝
    var avg: Float? = 0f, // 平均分贝
    var min: Float? = 0f, //最小分贝
)

/**
 * 卧床时间
 */
data class BedTime(
    var totalTime: Long? = null, // 卧床总时间
)

/**
 * 睡眠的时间 ()
 */
data class SleepTime(
    var start: Long, // 开始时间
    var end: Long, // 结束时间
    var total: Long, //睡眠总时间(endTime-startTime)
)

/**
 * 睡眠的状态
 */
data class SleepStageStatus(
    val awakeTime: Long? = 0L, // 醒着总时间
    val deepTime: Long? = 0L, // 深睡总时间
    val lightTime: Long? = 0L, // 浅睡总时间
    var sections: List<SleepReportSection>? = null, // 折线图的数据,50个点(深浅睡眠)
)

data class SleepReportSection(
    val start_time: Long, // 开始时间 - 先暂时不用
    val end_time: Long, // 结束时间
    val stage: Int, // 睡眠状态
    val v_acc_dx: Float, // 加速度传感器-x
    val v_acc_dy: Float, // 加速度传感器-y
    val v_acc_dz: Float, // 加速度传感器-z
    val max_decibel: Float, // 当前周期最大分贝
    val min_decibel: Float, // 当前周期最小分贝
    val avg_decibel: Float, // 当前周期平均分贝
    val base_decibel: Float // 基础分贝参考值
)

data class SleepRecordVoices(
    /**
     * TensorFlowConst.SNORING
     * TensorFlowConst.SPEECH
     * TensorFlowConst.FART
     * TensorFlowConst.COUGH
     */
    var map: Map<String, List<SleepRecordMp3File>>? = null, // 类型 + mp3的数据
    var max: Float? = 0f, // 全程的最大噪音
    var min: Float? = 0f, // 全程的最小噪音
    var avg: Float? = 0f, // 全程的平均噪音
)

class SleepRecordMp3File(
    val name: String? = null, // 文件名称
    val path: String? = null, // 文件路径
    val duration: Long? = 0, // 文件时长
    val createTime: Long? = 0, // 创建时间
)

/**
 * 打呼的分析
 */
data class SleepSnoringAnalysis(
    val totalTime: Long? = 0, // 打呼的时间
    val avg: Float? = 0f, // 打呼的平均分贝
    val max: Float? = 0f, // 打呼的最大分贝
    val min: Float? = 0f, // 打呼的最小分贝
    val analysisList: List<SleepAnalysisSnoring>? = null, // 本次睡眠打呼的分析
)

data class SleepAnalysisSnoring(
    val decibel: Float? = null,
)

/**
 * 呼吸暂停的次数
 */
class BreathStop(
    var times: Int? = 0, // 呼吸暂停次数
    var max: Long? = 0, // 呼吸暂停最大时长

)