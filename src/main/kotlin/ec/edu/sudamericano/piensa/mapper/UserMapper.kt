package ec.edu.sudamericano.piensa.mapper

import ec.edu.sudamericano.piensa.dto.UserDTO
import ec.edu.sudamericano.piensa.entity.User
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toUser(userDTO: UserDTO): User {
        return User(
            cedula = userDTO.cedula,
            name = userDTO.name,
            email = userDTO.email,
            password = userDTO.password
        )
    }

    fun toUserDTO(user: User): UserDTO {
        return UserDTO(
            cedula = user.cedula,
            name = user.name,
            email = user.email,
            password = user.password
        )
    }
}
