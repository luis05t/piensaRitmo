package ec.edu.sudamericano.piensa.service

import ec.edu.sudamericano.piensa.entity.Device
import ec.edu.sudamericano.piensa.repository.DeviceRepository
import ec.edu.sudamericano.piensa.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DeviceService(
    private val deviceRepository: DeviceRepository,
    private val userRepository: UserRepository
) {

    fun createDevice(deviceId: String, userId: Long): Device {
        val user = userRepository.findById(userId)
            .orElseThrow { RuntimeException("User not found with ID: $userId") }

        val device = Device(
            deviceId = deviceId,
            user = user,
            registeredAt = LocalDateTime.now()
        )
        return deviceRepository.save(device)
    }

    fun getDevice(id: Long): Device {
        return deviceRepository.findById(id)
            .orElseThrow { RuntimeException("Device not found with ID: $id") }
    }

    fun deleteDevice(id: Long) {
        if (!deviceRepository.existsById(id)) {
            throw RuntimeException("Device not found with ID: $id")
        }
        deviceRepository.deleteById(id)
    }

    fun updateDevice(id: Long, deviceId: String): Device {
        val existingDevice = deviceRepository.findById(id)
            .orElseThrow { RuntimeException("Device not found with ID: $id") }

        val updatedDevice = existingDevice.copy(deviceId = deviceId)
        return deviceRepository.save(updatedDevice)
    }
}
