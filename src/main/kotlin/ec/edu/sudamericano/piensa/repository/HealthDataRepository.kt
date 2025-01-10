package ec.edu.sudamericano.piensa.repository

import ec.edu.sudamericano.piensa.entity.HealthData
import org.springframework.data.jpa.repository.JpaRepository

interface HealthDataRepository : JpaRepository<HealthData, Long>
