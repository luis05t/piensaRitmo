package ec.edu.sudamericano.piensa.controller

import ec.edu.sudamericano.piensa.dto.AuthenticationRequest
import ec.edu.sudamericano.piensa.dto.AuthenticationResponse
import ec.edu.sudamericano.piensa.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/login")
    fun login(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authService.login(request))
    }

    @PostMapping("/register")
    fun register(@RequestBody request: AuthenticationRequest): ResponseEntity<String> {
        return ResponseEntity.ok(authService.register(request))
    }
}
