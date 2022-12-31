package ru.mephi.pp.model.dto.input.auth

import javax.validation.constraints.NotBlank

data class AccessTokenInput(
    @field:NotBlank
    val refreshToken: String
)
