package ru.mephi.pp.dto.attendance

import ru.mephi.pp.models.project.Project
import ru.mephi.pp.models.user.User
import java.util.*
import javax.persistence.*

class AttendanceDTO(
    var projectId: Long,
    var userId: Long,
    var date: Date,
    var status: Boolean
)