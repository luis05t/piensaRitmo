package ec.edu.sudamericano.piensa.controller

import ec.edu.sudamericano.piensa.dto.HealthDataDTO
import ec.edu.sudamericano.piensa.service.HealthDataService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/health-data")
class HealthDataController(private val healthDataService: HealthDataService) {

    @PostMapping
    fun createHealthData(@RequestBody healthDataDTO: HealthDataDTO): ResponseEntity<Any> =
        ResponseEntity.ok(healthDataService.createHealthData(healthDataDTO))
}
