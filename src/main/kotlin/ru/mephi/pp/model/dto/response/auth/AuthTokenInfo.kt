package ru.mephi.pp.model.dto.response.auth

import org.springframework.http.HttpStatus
import ru.mephi.pp.model.dto.ApiResponse
import ru.mephi.pp.model.entity.token.Token
import java.time.LocalDateTime
import javax.validation.constraints.Positive

data class AuthTokenInfo(
    val refreshToken: String,
    val accessToken: String,
) : ApiResponse {
    override val status: HttpStatus = HttpStatus.OK
    override val message: String = "Logged in"
    override val timestamp: LocalDateTime = LocalDateTime.now()
}

fun AuthTokenInfo.toEntity(@Positive userId: Long) = Token(
    userId = userId,
    refreshToken = refreshToken,
    accessToken = accessToken
)

fun Token.toDto() = AuthTokenInfo(
    refreshToken = refreshToken,
    accessToken = accessToken
)
