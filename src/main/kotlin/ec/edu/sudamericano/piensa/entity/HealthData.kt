package ec.edu.sudamericano.piensa.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "health_data")
data class HealthData(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    val user: User,

    @Column(nullable = false)
    val heartRate: Int,

    @Column(nullable = false)
    val temperature: Double,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)
