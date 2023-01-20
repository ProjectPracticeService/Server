package ru.mephi.pp.model.dto.info.task

import ru.mephi.pp.model.entity.tasks.Task
import ru.mephi.pp.model.entity.tasks.TaskStatus
import java.util.*


data class TaskInfo(
    val taskId: Long,
    val description: String,
    val dateFrom: Date,
    val dateTo: Date,
    val status: TaskStatus
)

fun Task.toDto() = TaskInfo(
    taskId = id ?: -1,
    description = description,
    dateFrom = dateFrom,
    dateTo = dateTo,
    status = status
)