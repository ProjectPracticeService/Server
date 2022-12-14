package ru.mephi.pp.model.dto.response.profile

import ru.mephi.pp.model.entity.profile.EducationalOrganization
import javax.validation.constraints.NotBlank

data class EducationalOrganizationDto(

    @field:NotBlank
    var name: String,

    @field:NotBlank
    var city: Int,

//    var users: List<Long>
)

fun EducationalOrganizationDto.toEntity() = EducationalOrganization(
    name = name,
    city = city
)





