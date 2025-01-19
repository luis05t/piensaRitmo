package ec.edu.sudamericano.piensa.service

import ec.edu.sudamericano.piensa.dto.AuthenticationRequest
import ec.edu.sudamericano.piensa.dto.AuthenticationResponse
import ec.edu.sudamericano.piensa.entity.User
import ec.edu.sudamericano.piensa.repository.UserRepository
import ec.edu.sudamericano.piensa.security.JwtTokenProvider

import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun login(request: AuthenticationRequest): AuthenticationResponse {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )
        val token = jwtTokenProvider.generateToken(authentication)
        return AuthenticationResponse(token)
    }

    fun register(request: AuthenticationRequest): String {
        val user = User(
            cedula = "1234567890", // This should be passed or generated
            name = "New User",
            email = request.email,
            password = "password" // Hash this password in a real app
        )
        userRepository.save(user)
        return "User registered successfully"
    }
}
