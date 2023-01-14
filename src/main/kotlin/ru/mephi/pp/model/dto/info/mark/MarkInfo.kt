package ru.mephi.pp.model.dto.info.mark

import ru.mephi.pp.model.dto.info.profile.EduOrgInfo
import ru.mephi.pp.model.dto.info.profile.SkillInfo
import ru.mephi.pp.model.dto.info.profile.toDto
import ru.mephi.pp.model.dto.info.project.ProjectInfo
import ru.mephi.pp.model.dto.info.project.toDto
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.model.entity.marks.MarkValue
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.user.User
import java.sql.Timestamp

data class MarkInfo(
    var id: Long,
    var mark: MarkValue,
    var date: Timestamp,
    var projectIds: Long,
    var userId: Long

    )

fun Mark.toDto(project: Project, user: User) = MarkInfo(
    id = id ?: -1,
    mark = mark,
    date = date,
    projectIds = projects.map { it.id ?: -1 },
    usersIds = users.map { it.id ?: -1 }
)
