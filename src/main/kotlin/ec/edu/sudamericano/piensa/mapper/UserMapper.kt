package ec.edu.sudamericano.piensa.mapper

import ec.edu.sudamericano.piensa.dto.UserDTO
import ec.edu.sudamericano.piensa.entity.User

object UserMapper {
    fun toEntity(userDTO: UserDTO): User {
        return User(
            cedula = userDTO.cedula,
            name = userDTO.name,
            email = userDTO.email
        )
    }

    fun toDTO(user: User): UserDTO {
        return UserDTO(
            cedula = user.cedula,
            name = user.name,
            email = user.email
        )
    }
}