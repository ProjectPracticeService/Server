package ru.mephi.pp.model.dto.input.task

import ru.mephi.pp.model.entity.tasks.TaskStatus
import java.util.*

class TaskDto(
    var projectId: Long,
    var assigneesId: List<Long>,
    var description: String,
    var dateFrom: Date,
    var dateTo: Date,
    var status: TaskStatus
)