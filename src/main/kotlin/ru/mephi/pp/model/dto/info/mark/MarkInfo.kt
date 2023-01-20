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

    )

fun Mark.toDto() = MarkInfo(
    id = id ?: -1,
    mark = mark,
    date = date
)
