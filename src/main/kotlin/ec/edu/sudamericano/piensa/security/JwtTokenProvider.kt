package ec.edu.sudamericano.piensa.security

import ec.edu.sudamericano.piensa.config.JwtConfig
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(private val jwtConfig: JwtConfig) {

    fun generateToken(authentication: Authentication): String {
        val username = authentication.name
        val currentTime = Date()
        val expirationTime = Date(currentTime.time + jwtConfig.getExpirationTime())

        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(currentTime)
            .setExpiration(expirationTime)
            .signWith(jwtConfig.getSecretKey(), SignatureAlgorithm.HS512)
            .compact()
    }
}
