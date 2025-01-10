package ec.edu.sudamericano.piensa.service

import ec.edu.sudamericano.piensa.dto.UserDTO
import ec.edu.sudamericano.piensa.entity.User
import ec.edu.sudamericano.piensa.mapper.UserMapper
import ec.edu.sudamericano.piensa.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun createUser(userDTO: UserDTO): User {
        val user = UserMapper.toEntity(userDTO)
        return userRepository.save(user)
    }

    fun getUserByCedula(cedula: String): User? {
        return userRepository.findByCedula(cedula)
    }

    fun deleteUser(cedula: String): String {
        val user = userRepository.findByCedula(cedula)
            ?: throw Exception("User not found")
        userRepository.delete(user)
        return "User deleted successfully"
    }
}
