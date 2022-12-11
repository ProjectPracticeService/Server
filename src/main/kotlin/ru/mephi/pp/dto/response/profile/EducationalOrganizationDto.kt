package ru.mephi.pp.dto.response.profile

import ru.mephi.pp.dto.request.auth.CreateAccountDto
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.models.user.User
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





