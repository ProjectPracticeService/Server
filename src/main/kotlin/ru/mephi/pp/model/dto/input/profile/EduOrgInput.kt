package ru.mephi.pp.model.dto.input.profile

import ru.mephi.pp.model.entity.profile.EduOrg
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

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
