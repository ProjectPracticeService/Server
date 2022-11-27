package ru.mephi.pp.dto.undefined.profile

import ru.mephi.pp.models.profile.ProficiencyLevel

class SkillDto(
    var userId: Long,
    var name: String,
    var experience: String,
    var profLevel: ProficiencyLevel
)