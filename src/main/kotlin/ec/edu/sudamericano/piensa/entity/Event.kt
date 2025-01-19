package ec.edu.sudamericano.piensa.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "events")
data class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    val device: Device,

    @Column(name = "event_type", nullable = false)
    val eventType: String,

    @Column(name = "heart_rate", nullable = false)
    val heartRate: Int,

    @Column(name = "temperature", nullable = false)
    val temperature: Double,

    @Column(name = "recorded_at")
    val recordedAt: LocalDateTime = LocalDateTime.now()
)
