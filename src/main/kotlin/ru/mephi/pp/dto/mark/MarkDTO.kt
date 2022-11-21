package ru.mephi.pp.dto.mark

import ru.mephi.pp.models.marks.MarkValue
import ru.mephi.pp.models.project.Project
import ru.mephi.pp.models.user.User
import java.sql.Timestamp
import javax.persistence.*

class MarkDTO(
    var projectId: Long,
    var userId: Long,
    var mark: MarkValue,
    var date: Timestamp
)