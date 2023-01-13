package ru.mephi.pp.model.dto.input.mark

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.model.entity.marks.MarkValue
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.user.User
import java.sql.Timestamp


data class MarkInput(
    @field:NotBlank
    val mark: MarkValue,

    @field:NotBlank
    val date: Timestamp,

    @field:NotEmpty
    val userId: Long
)

fun MarkInput.toEntity(user: User, project: Project) = Mark(
    id = null,
    mark = mark,
    date = date,
    user = user,
    project = project
)