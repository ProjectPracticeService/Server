package ru.mephi.pp.dto.profile

import ru.mephi.pp.models.user.User
import javax.persistence.*

class EducationalOrganizationDTO(
    var name: String,
    var city: Int,
    var users: List<Long>
)
