package ec.edu.sudamericano.piensa.repository

import ec.edu.sudamericano.piensa.entity.Device
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeviceRepository : JpaRepository<Device, Long> {
    fun findByDeviceId(deviceId: String): Device?
}
