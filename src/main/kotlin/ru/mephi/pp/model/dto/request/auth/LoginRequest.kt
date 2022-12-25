package ru.mephi.pp.model.dto.request.auth

import ru.mephi.pp.model.dto.validators.NotBlankOrNull
import javax.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlankOrNull
    val username: String,

    @field:NotBlankOrNull
    val email: String,

    @field:NotBlank
    val password: String
)
