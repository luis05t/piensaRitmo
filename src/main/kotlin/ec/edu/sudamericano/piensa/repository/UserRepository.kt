package ec.edu.sudamericano.piensa.repository

import ec.edu.sudamericano.piensa.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByCedula(cedula: String): User?
}
