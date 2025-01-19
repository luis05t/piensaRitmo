package ec.edu.sudamericano.piensa.mapper

import ec.edu.sudamericano.piensa.controller.UserController
import ec.edu.sudamericano.piensa.dto.DeviceDTO
import ec.edu.sudamericano.piensa.entity.Device
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.stereotype.Component

@Component
class DeviceMapper(private val user: UserController) {

    fun toDevice(deviceDTO: DeviceDTO, user: SecurityProperties.User): Device {
        return Device(
            deviceId = deviceDTO.deviceId,
            user = user
        )
    }

    fun toDeviceDTO(device: Device): DeviceDTO {
        return DeviceDTO(
            deviceId = device.deviceId,
            userId = device.user.id,
            registeredAt = device.registeredAt
        )
    }
}
