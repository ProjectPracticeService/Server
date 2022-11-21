package ru.mephi.pp.dto.task

import ru.mephi.pp.models.project.Project
import ru.mephi.pp.models.user.User
import java.util.*
import javax.persistence.*

class Task(
    var projectId: Long,
    var assigneesId: List<Long>,
    var description: String,
    var dateFrom: Date,
    var dateTo: Date,
    var status: TaskStatus
)