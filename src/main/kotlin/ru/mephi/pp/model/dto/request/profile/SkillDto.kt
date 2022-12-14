package ru.mephi.pp.model.dto.request.profile

import ru.mephi.pp.model.entity.profile.ProficiencyLevel

class SkillDto(
    var name: String,
    var experience: String,
    var profLevel: ProficiencyLevel
)