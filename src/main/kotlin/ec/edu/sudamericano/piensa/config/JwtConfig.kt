package ec.edu.sudamericano.piensa.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:application.yml")
class JwtConfig {
    fun getExpirationTime() {

    }

    @Value("\${jwt.secret}")
    lateinit var secret: String

    @Value("\${jwt.expiration}")
    var expirationTime: Long = 0
}
