package ru.mephi.pp.model.dto.input.auth

import javax.validation.constraints.NotBlank

data class CredentialsInput(
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String
)
