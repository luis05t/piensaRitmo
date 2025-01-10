package ec.edu.sudamericano.piensa.mapper

import ec.edu.sudamericano.piensa.dto.HealthDataDTO
import ec.edu.sudamericano.piensa.entity.HealthData
import ec.edu.sudamericano.piensa.entity.User

object HealthDataMapper {
    fun toEntity(healthDataDTO: HealthDataDTO, user: User): HealthData {
        return HealthData(
            user = user,
            heartRate = healthDataDTO.heartRate,
            temperature = healthDataDTO.temperature
        )
    }
}
