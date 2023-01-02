package ru.mephi.pp.model.dto.input.profile

import jakarta.validation.constraints.*
import ru.mephi.pp.model.entity.profile.EduOrg

data class EduOrgInput(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val city: Long,

    @field:NotEmpty
    val userIds: List<Long>
)

fun EduOrgInput.toEntity() = EduOrg(
    id = null,
    name = name,
    city = city
)
