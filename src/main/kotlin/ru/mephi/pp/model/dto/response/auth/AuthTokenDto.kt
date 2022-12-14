package ru.mephi.pp.model.dto.response.auth

import ru.mephi.pp.model.entity.token.Token
import javax.validation.constraints.Positive

data class AuthTokenDto(
    val refreshToken: String,
    val accessToken: String
)

fun AuthTokenDto.toEntity(@Positive userId: Long) = Token(
    userId = userId,
    refreshToken = refreshToken,
    accessToken = accessToken
)
