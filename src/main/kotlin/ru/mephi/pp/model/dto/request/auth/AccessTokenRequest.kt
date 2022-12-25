package ru.mephi.pp.model.dto.request.auth

import javax.validation.constraints.NotBlank

data class AccessTokenRequest(
    @field:NotBlank
    val refreshToken: String
)
