package ru.mephi.pp.service

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.info.task.TaskInfo
import ru.mephi.pp.model.dto.info.task.toDto
import ru.mephi.pp.model.dto.input.task.TaskInput
import ru.mephi.pp.model.dto.input.task.toEntity
import ru.mephi.pp.model.repository.ProjectRepo
import ru.mephi.pp.model.repository.TaskRepo
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.AccessException
import ru.mephi.pp.utils.exception.NotFoundException
import java.util.*

@Service
class TaskService(
    @Autowired private val userRepo: UserRepository,
    @Autowired private val taskRepo: TaskRepo,
    @Autowired private val projectRepo: ProjectRepo
) {


    fun getTaskByProjectId(projectId: Long): List<TaskInfo> {
        return taskRepo.getTaskByProjectId(projectId).map { it.toDto() }
            ?: throw NotFoundException("Project with id=$projectId is NOT found")
    }

    fun getTaskByDate(projectId: Long, date: Date): List<TaskInfo> {
        return taskRepo.getTaskByProjectIdAndDateTo(projectId, date).map { it.toDto() }
            ?: throw NotFoundException("Project with id=$projectId is NOT found")
    }

    fun createTask(projectId: Long, userId: Long, input: TaskInput) {
        val user = userRepo.getUserById(userId)
            ?: throw NotFoundException("User with id=$userId is NOT found")
        val project = projectRepo.getProjectsById(projectId)
            ?: throw NotFoundException("Project with id=$projectId is NOT found")
        user.addToTask(input.toEntity(project, user))
        userRepo.save(user)
    }

    fun updateUserSkill(isMentor: Boolean, taskId: Long, request: TaskInput) {
        taskRepo.getTaskById(taskId)?.let { task ->
            if (!isMentor) {
                throw AccessException("You must be mentor, to modify task with id=$taskId")
            }
            task.description = request.description
            task.status = task.status
            task.assigneesId = task.assigneesId
            task.dateFrom = task.dateFrom
            task.dateTo = task.dateTo
            taskRepo.save(task)
        } ?: throw NotFoundException("Task with id=$taskId is NOT found")
    }

    @Transactional
    fun deleteUserSkill(projectId: Long, isMentor: Boolean, taskId: Long) {
        taskRepo.getTaskByProjectId(projectId)?.let { task ->
            if (!isMentor) {
                throw AccessException("You must be mentor, to delete task's (id=$taskId) skill with id=$taskId")
            }
            taskRepo.removeTaskById(taskId)
        } ?: throw NotFoundException("User with id=$taskId is NOT found")
    }



}