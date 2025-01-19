package ec.edu.sudamericano.piensa.repository

import ec.edu.sudamericano.piensa.entity.Event
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : JpaRepository<Event, Long> {
    fun findByDeviceId(deviceId: Long): List<Event>
}
