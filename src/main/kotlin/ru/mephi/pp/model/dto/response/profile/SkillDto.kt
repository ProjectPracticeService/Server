package ru.mephi.pp.model.dto.response.profile

import ru.mephi.pp.model.entity.profile.ProficiencyLevel

class SkillDto(
    var userId: Long,
    var name: String,
    var experience: String,
    var profLevel: ProficiencyLevel
)