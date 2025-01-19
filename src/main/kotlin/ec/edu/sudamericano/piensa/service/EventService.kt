package ec.edu.sudamericano.piensa.service

import ec.edu.sudamericano.piensa.dto.EventDTO
import ec.edu.sudamericano.piensa.entity.Event
import ec.edu.sudamericano.piensa.repository.DeviceRepository
import ec.edu.sudamericano.piensa.repository.EventRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EventService(
    private val eventRepository: EventRepository,
    private val deviceRepository: DeviceRepository
) {

    fun createEvent(eventDTO: EventDTO): Event {
        val device = deviceRepository.findById(eventDTO.deviceId)
            .orElseThrow { RuntimeException("Device not found with ID: ${eventDTO.deviceId}") }

        val event = Event(
            device = device,
            eventType = eventDTO.eventType,
            heartRate = eventDTO.heartRate,
            temperature = eventDTO.temperature,
            recordedAt = LocalDateTime.now()
        )
        return eventRepository.save(event)
    }

    fun getEvent(id: Long): Event {
        return eventRepository.findById(id)
            .orElseThrow { RuntimeException("Event not found with ID: $id") }
    }

    fun deleteEvent(id: Long) {
        if (!eventRepository.existsById(id)) {
            throw RuntimeException("Event not found with ID: $id")
        }
        eventRepository.deleteById(id)
    }

    fun updateEvent(id: Long, eventDTO: EventDTO): Event {
        val existingEvent = eventRepository.findById(id)
            .orElseThrow { RuntimeException("Event not found with ID: $id") }

        val updatedEvent = existingEvent.copy(
            eventType = eventDTO.eventType,
            heartRate = eventDTO.heartRate,
            temperature = eventDTO.temperature
        )
        return eventRepository.save(updatedEvent)
    }
}
