package ec.edu.sudamericano.piensa.mapper

import ec.edu.sudamericano.piensa.dto.EventDTO
import ec.edu.sudamericano.piensa.entity.Device
import ec.edu.sudamericano.piensa.entity.Event
import org.springframework.stereotype.Component

@Component
class EventMapper {

    fun toEvent(eventDTO: EventDTO, device: Device): Event {
        return Event(
            device = device,
            eventType = eventDTO.eventType,
            heartRate = eventDTO.heartRate,
            temperature = eventDTO.temperature
        )
    }

    fun toEventDTO(event: Event): EventDTO {
        return EventDTO(
            deviceId = event.device.id,
            eventType = event.eventType,
            heartRate = event.heartRate,
            temperature = event.temperature,
            recordedAt = event.recordedAt
        )
    }
}
