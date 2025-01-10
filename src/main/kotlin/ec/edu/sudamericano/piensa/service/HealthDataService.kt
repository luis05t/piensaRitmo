package ec.edu.sudamericano.piensa.service

import ec.edu.sudamericano.piensa.dto.HealthDataDTO
import ec.edu.sudamericano.piensa.entity.HealthData
import ec.edu.sudamericano.piensa.mapper.HealthDataMapper
import ec.edu.sudamericano.piensa.repository.HealthDataRepository
import ec.edu.sudamericano.piensa.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class HealthDataService(
    private val healthDataRepository: HealthDataRepository,
    private val userRepository: UserRepository
) {
    fun createHealthData(healthDataDTO: HealthDataDTO): HealthData {
        val user = userRepository.findById(healthDataDTO.userId)
            .orElseThrow { Exception("User not found") }
        val healthData = HealthDataMapper.toEntity(healthDataDTO, user)
        return healthDataRepository.save(healthData)
    }
}
