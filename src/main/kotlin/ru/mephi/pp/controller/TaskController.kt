package ru.mephi.pp.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import ru.mephi.pp.model.dto.info.task.TaskInfo
import ru.mephi.pp.model.dto.input.task.TaskInput
import ru.mephi.pp.model.entity.tasks.Task
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.service.TaskService

@RestController
@RequestMapping("/api/users/{userId}/{projectId}/tasks")
class TaskController {

    @Autowired
    lateinit var taskService: TaskService

    @GetMapping(value = ["", "/"])
    @ResponseBody
    fun getTasksByProject(
        @PathVariable userId: String,
        @PathVariable projectId: String,
        auth: Authentication
    ): List<TaskInfo> {
        return taskService.getTaskByProjectId(projectId.toLong())
    }


    @PostMapping(value = ["", "/"])
    @ResponseBody
    fun createTask(
        @PathVariable userId: String,
        @PathVariable projectId: String,
        @Valid @RequestBody request: TaskInput,
        auth: Authentication
    ) {
        taskService.createTask(projectId.toLong(), userId.toLong(), request)
    }

    @PutMapping("/{taskId}")
    @ResponseBody
    fun updateUserPortfolio(
        @PathVariable taskId: String,
        @Valid @RequestBody request: TaskInput,
        auth: Authentication
    ) {
        val isMentor = (auth.authorities as List<*>).contains(Role.Mentor)
        taskService.updateUserSkill(isMentor, taskId.toLong(), request)
    }


    @DeleteMapping("/{taskId}")
    @ResponseBody
    fun deleteUserPortfolio(
        @PathVariable taskId: String,
        @PathVariable projectId: String,
        auth: Authentication
    ) {
        val isMentor = (auth.authorities as List<*>).contains(Role.Mentor)
        taskService.deleteUserSkill(projectId.toLong(), isMentor, taskId.toLong())
    }

}