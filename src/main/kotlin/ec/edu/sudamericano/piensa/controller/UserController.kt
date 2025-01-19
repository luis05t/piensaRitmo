package ec.edu.sudamericano.piensa.controller

import ec.edu.sudamericano.piensa.dto.UserDTO
import ec.edu.sudamericano.piensa.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        retzurn ResponseEntity.ok(userService.createUser(userDTO))
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserDTO> {
        return ResponseEntity.ok(userService.getUser(id))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    @PatchMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        return ResponseEntity.ok(userService.updateUser(id, userDTO))
    }
}
