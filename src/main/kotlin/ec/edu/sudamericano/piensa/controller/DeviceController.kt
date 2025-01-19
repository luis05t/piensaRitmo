package ec.edu.sudamericano.piensa.controller

import ec.edu.sudamericano.piensa.dto.DeviceDTO
import ec.edu.sudamericano.piensa.service.DeviceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/devices")
class DeviceController(private val deviceService: DeviceService) {

    @PostMapping
    fun createDevice(@RequestBody deviceDTO: DeviceDTO): ResponseEntity<DeviceDTO> {
        return ResponseEntity.ok(deviceService.createDevice(deviceDTO))
    }

    @GetMapping("/{id}")
    fun getDevice(@PathVariable id: Long): ResponseEntity<DeviceDTO> {
        return ResponseEntity.ok(deviceService.getDevice(id))
    }

    @DeleteMapping("/{id}")
    fun deleteDevice(@PathVariable id: Long): ResponseEntity<Void> {
        deviceService.deleteDevice(id)
        return ResponseEntity.noContent().build()
    }

    @PatchMapping("/{id}")
    fun updateDevice(@PathVariable id: Long, @RequestBody deviceDTO: DeviceDTO): ResponseEntity<DeviceDTO> {
        return ResponseEntity.ok(deviceService.updateDevice(id, deviceDTO))
    }
}
