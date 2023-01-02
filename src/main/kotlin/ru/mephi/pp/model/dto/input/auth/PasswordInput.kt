package ru.mephi.pp.model.dto.input.auth

import jakarta.validation.constraints.*

data class PasswordInput(
    @field:NotBlank
    @field:Size(min = 8)
    val oldPassword: String,

    @field:NotBlank
    @field:Size(min = 8)
    val newPassword: String
)
