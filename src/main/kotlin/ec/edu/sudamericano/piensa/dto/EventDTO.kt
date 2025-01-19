package ec.edu.sudamericano.piensa.dto

import java.time.LocalDateTime

data class EventDTO(
    val id: Long? = null,
    val deviceId: Long,
    val eventType: String,
    val heartRate: Int,
    val temperature: Double,
    val recordedAt: LocalDateTime
)
