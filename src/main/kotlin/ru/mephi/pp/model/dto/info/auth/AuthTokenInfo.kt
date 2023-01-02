package ru.mephi.pp.model.dto.info.auth

import ru.mephi.pp.model.entity.token.Token

data class AuthTokenInfo(
    val refreshToken: String,
    val accessToken: String,
)

fun AuthTokenInfo.toEntity(userId: Long) = Token(
    userId = userId,
    refreshToken = refreshToken,
    accessToken = accessToken
)

fun Token.toDto() = AuthTokenInfo(
    refreshToken = refreshToken,
    accessToken = accessToken
)
