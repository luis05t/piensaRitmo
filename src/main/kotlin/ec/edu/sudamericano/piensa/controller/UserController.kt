package ec.edu.sudamericano.piensa.controller

import ec.edu.sudamericano.piensa.dto.UserDTO
import ec.edu.sudamericano.piensa.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<Any> =
        ResponseEntity.ok(userService.createUser(userDTO))

    @GetMapping("/{cedula}")
    fun getUserByCedula(@PathVariable cedula: String): ResponseEntity<Any> =
        ResponseEntity.ok(userService.getUserByCedula(cedula) ?: throw Exception("User not found"))

    @DeleteMapping("/{cedula}")
    fun deleteUser(@PathVariable cedula: String): ResponseEntity<Any> =
        ResponseEntity.ok(userService.deleteUser(cedula))
}
