package ru.mephi.pp.dto.response.task

import ru.mephi.pp.models.tasks.TaskStatus
import java.util.*

class TaskDto(
    var taskId: Long,
    var projectId: Long,
    var assigneesId: List<Long>,
    var description: String,
    var dateFrom: Date,
    var dateTo: Date,
    var status: TaskStatus
)