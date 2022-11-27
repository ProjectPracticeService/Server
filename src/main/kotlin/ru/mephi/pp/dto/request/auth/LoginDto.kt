package ru.mephi.pp.dto.request.auth

import ru.mephi.pp.dto.validators.NotBlankOrNull
import javax.validation.constraints.NotBlank

data class LoginDto(
    @field:NotBlankOrNull
    val username: String,

    @field:NotBlankOrNull
    val email: String,

    @NotBlank
    val password: String
)
