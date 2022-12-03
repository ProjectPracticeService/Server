package ru.mephi.pp.dto.request.profile

import ru.mephi.pp.models.profile.ProficiencyLevel

class SkillDto(
    var name: String,
    var experience: String,
    var profLevel: ProficiencyLevel
)