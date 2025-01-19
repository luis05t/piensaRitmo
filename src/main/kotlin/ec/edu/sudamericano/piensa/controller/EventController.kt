package ec.edu.sudamericano.piensa.controller

import ec.edu.sudamericano.piensa.dto.EventDTO
import ec.edu.sudamericano.piensa.service.EventService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/events")
class EventController(private val eventService: EventService) {

    @PostMapping
    fun createEvent(@RequestBody eventDTO: EventDTO): ResponseEntity<EventDTO> {
        return ResponseEntity.ok(eventService.createEvent(eventDTO))
    }

    @GetMapping("/{id}")
    fun getEvent(@PathVariable id: Long): ResponseEntity<EventDTO> {
        return ResponseEntity.ok(eventService.getEvent(id))
    }

    @DeleteMapping("/{id}")
    fun deleteEvent(@PathVariable id: Long): ResponseEntity<Void> {
        eventService.deleteEvent(id)
        return ResponseEntity.noContent().build()
    }

    @PatchMapping("/{id}")
    fun updateEvent(@PathVariable id: Long, @RequestBody eventDTO: EventDTO): ResponseEntity<EventDTO> {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO))
    }
}
