package ru.mephi.pp.model.dto.info.profile

import ru.mephi.pp.model.entity.profile.ProficiencyLevel
import ru.mephi.pp.model.entity.profile.Skill

data class SkillInfo(
    val id: Long,
    val name: String,
    val profLevel: ProficiencyLevel
)

fun Skill.toDto() = SkillInfo(
    id = id ?: -1,
    name = name,
    profLevel = profLevel
)