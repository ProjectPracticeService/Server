package ru.mephi.pp.model.dto.info.project

import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.project.Status

data class ProjectInfo(
    val id: Long,
    val title: String,
    val status: Status,
    val students: List<ParticipantInfo>,
    val user: ParticipantInfo
)

fun Project.toDto() = ProjectInfo(
    id = id ?: -1,
    title = title,
    status = status,
    students = students.map { it.toDto() },
    user = user.toDto()
)
