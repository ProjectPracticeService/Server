package ru.mephi.pp.model.dto.input.task

import jakarta.validation.constraints.NotBlank
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.tasks.Task
import ru.mephi.pp.model.entity.tasks.TaskStatus
import ru.mephi.pp.model.entity.user.User
import java.util.*



data class TaskInput(
    @field:NotBlank
    val description: String,
    val dateFrom: Date,
    @field:NotBlank
    val dateTo: Date,
    val status: TaskStatus,
    val assigneesId: List<User>
)

fun TaskInput.toEntity(project: Project, user: User) = Task(
    id = -1,
    project = project,
    description = description,
    dateFrom = dateFrom,
    dateTo = dateTo,
    status = status,
    assigneesId = mutableListOf(user)
)