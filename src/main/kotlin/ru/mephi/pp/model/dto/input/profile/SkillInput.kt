package ru.mephi.pp.model.dto.input.profile

import ru.mephi.pp.model.entity.profile.ProficiencyLevel
import ru.mephi.pp.model.entity.profile.Skill
import ru.mephi.pp.model.entity.user.User
import javax.validation.constraints.NotBlank

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