package ru.mephi.pp.model.dto.request.profile

import ru.mephi.pp.model.entity.profile.EduOrg
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class EduOrgRequest(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val city: Long,

    @field:NotEmpty
    val userIds: List<Long>
)

fun EduOrgRequest.toEntity() = EduOrg(
    id = null,
    name = name,
    city = city
)
