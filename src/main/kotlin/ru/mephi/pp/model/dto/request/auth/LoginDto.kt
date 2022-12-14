package ru.mephi.pp.model.dto.request.auth

import ru.mephi.pp.model.dto.validators.NotBlankOrNull
import javax.validation.constraints.NotBlank

data class LoginDto(

    @field:NotBlankOrNull
    val username: String,

    @field:NotBlankOrNull
    val email: String,

    @NotBlank
    val password: String
)
