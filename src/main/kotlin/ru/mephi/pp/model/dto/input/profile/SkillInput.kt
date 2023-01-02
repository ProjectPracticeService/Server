package ru.mephi.pp.model.dto.input.profile

import jakarta.validation.constraints.NotBlank
import ru.mephi.pp.model.entity.profile.ProficiencyLevel
import ru.mephi.pp.model.entity.profile.Skill
import ru.mephi.pp.model.entity.user.User

data class SkillInput(
    @field:NotBlank
    val name: String,

    val profLevel: ProficiencyLevel
)

fun SkillInput.toEntity(user: User) = Skill(
    id = -1,
    user = user,
    name = name,
    profLevel = profLevel
)