package ru.mephi.pp.model.dto.info.auth

import ru.mephi.pp.model.entity.token.Token
import javax.validation.constraints.Positive

data class AuthTokenInfo(
    val refreshToken: String,
    val accessToken: String,
)

fun AuthTokenInfo.toEntity(@Positive userId: Long) = Token(
    userId = userId,
    refreshToken = refreshToken,
    accessToken = accessToken
)

fun Token.toDto() = AuthTokenInfo(
    refreshToken = refreshToken,
    accessToken = accessToken
)
