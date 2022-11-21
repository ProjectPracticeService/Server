package ru.mephi.pp.dto.profile

import ru.mephi.pp.models.profile.ProficiencyLevel
import ru.mephi.pp.models.user.User
import javax.persistence.*

class SkillDTO(
    var userId: Long,
    var name: String,
    var experience: String,
    var profLevel: ProficiencyLevel
)