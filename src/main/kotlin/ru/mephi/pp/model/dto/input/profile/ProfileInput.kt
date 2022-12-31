package ru.mephi.pp.model.dto.input.profile

import com.fasterxml.jackson.annotation.JsonInclude
import ru.mephi.pp.utils.validators.NotBlankOrNull

data class ProfileInput(
    @field:NotBlankOrNull
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val name: String? = null,

    @field:NotBlankOrNull
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val surname: String? = null,

    @field:NotBlankOrNull
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val patronymic: String? = null,

    @field:NotBlankOrNull
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val status: String? = null,

    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    val telegramId: Long? = null
)