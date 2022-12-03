package ru.mephi.pp.dto.response.profile

class EducationalOrganizationDto(
    var eduOrgId: Long,
    var name: String,
    var city: Int,
    var users: List<Long>
)
