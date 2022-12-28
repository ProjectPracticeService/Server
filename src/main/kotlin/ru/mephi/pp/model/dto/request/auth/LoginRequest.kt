package ru.mephi.pp.model.dto.request.auth

import com.fasterxml.jackson.annotation.JsonInclude
import ru.mephi.pp.model.dto.validators.NotBlankOrNull
import javax.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlankOrNull
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val username: String? = null,

    @field:NotBlankOrNull
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val email: String? = null,

    @field:NotBlank
    val password: String
)
