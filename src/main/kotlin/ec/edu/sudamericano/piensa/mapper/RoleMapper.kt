package ec.edu.sudamericano.piensa.mapper

import ec.edu.sudamericano.piensa.entity.Role
import org.springframework.stereotype.Component

@Component
class RoleMapper {

    fun toRole(name: String): Role {
        return Role(name = name)
    }
}
