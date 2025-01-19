package ec.edu.sudamericano.piensa.service

import ec.edu.sudamericano.piensa.dto.UserDTO
import ec.edu.sudamericano.piensa.mapper.UserMapper
import ec.edu.sudamericano.piensa.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) {

    fun createUser(userDTO: UserDTO): UserDTO {
        val user = userMapper.toUser(userDTO)
        return userMapper.toUserDTO(userRepository.save(user))
    }

    fun getUser(id: Long): UserDTO {
        val user = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
        return userMapper.toUserDTO(user)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    fun updateUser(id: Long, userDTO: UserDTO): UserDTO {
        val user = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
        val updatedUser = user.copy(name = userDTO.name, email = userDTO.email, cedula = userDTO.cedula)
        return userMapper.toUserDTO(userRepository.save(updatedUser))
    }
}
