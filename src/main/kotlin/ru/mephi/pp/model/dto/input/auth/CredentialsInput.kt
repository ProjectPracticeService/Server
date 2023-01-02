package ru.mephi.pp.model.dto.input.auth

import jakarta.validation.constraints.*

data class CredentialsInput(
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String
)
