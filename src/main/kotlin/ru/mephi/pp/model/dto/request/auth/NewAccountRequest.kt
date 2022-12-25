package ru.mephi.pp.model.dto.request.auth

import com.fasterxml.jackson.annotation.JsonInclude
import ru.mephi.pp.model.dto.validators.NotBlankOrNull
import ru.mephi.pp.model.entity.user.User
import javax.validation.constraints.*

data class NewAccountRequest(
    @field:NotEmpty
    val username: String,

    @field:NotBlank
    val email: String,

    @field:NotBlank
    @field:Size(min = 8)
    val password: String,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val surname: String,

    @field:NotBlankOrNull
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val patronymic: String? = null
)

fun NewAccountRequest.toEntity() = User(
    username = username,
    email = email,
    password = password,
    name = name,
    surname = surname,
    patronymic = patronymic
)