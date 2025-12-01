package dev.jdtech.jellyfin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

enum class FindroidSegmentType {
    INTRO, CREDITS, UNKNOWN
}

@Serializable
data class FindroidSegment(
    var type: FindroidSegmentType = FindroidSegmentType.UNKNOWN,
    val startTime: Double,
    val endTime: Double,
    val showAt: Double,
    val hideAt: Double,
)

@Serializable
data class TimestampsResponse(
    @SerialName("Introduction")
    val introduction: SegmentData? = null,
    @SerialName("Credits")
    val credits: SegmentData? = null,
)

@Serializable
data class SegmentData(
    val Valid: Boolean,
    val Start: Double,
    val End: Double,
)

fun FindroidSegmentDto.toFindroidSegment(): FindroidSegment {
    return FindroidSegment(
        type = type,
        startTime = startTime,
        endTime = endTime,
        showAt = showAt,
        hideAt = hideAt,
    )
}
