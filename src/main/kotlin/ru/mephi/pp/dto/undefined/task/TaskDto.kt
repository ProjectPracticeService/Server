package ru.mephi.pp.dto.undefined.task

import java.util.*

class TaskDto(
    var projectId: Long,
    var assigneesId: List<Long>,
    var description: String,
    var dateFrom: Date,
    var dateTo: Date,
    var status: TaskStatusDto
)