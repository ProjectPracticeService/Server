package ru.mephi.pp.model.dto.request.auth

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class NewPasswordRequest(
    @field:NotBlank
    @field:Size(min = 8)
    val oldPassword: String,

    @field:NotBlank
    @field:Size(min = 8)
    val newPassword: String
)
