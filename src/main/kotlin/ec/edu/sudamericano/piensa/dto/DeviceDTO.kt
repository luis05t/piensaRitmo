package ec.edu.sudamericano.piensa.dto

import java.time.LocalDateTime

data class DeviceDTO(
    val deviceId: String,
    val userId: Long,
    val registeredAt: LocalDateTime? = null
)
