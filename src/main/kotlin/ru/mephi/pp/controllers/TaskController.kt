package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.tasks.Task
import ru.mephi.pp.repo.TaskRepo

@RestController
@RequestMapping("task")
class TaskController {

    lateinit var taskRepo:TaskRepo

    @GetMapping("{id}")
    fun getTask(@PathVariable("id") task: Task): Task {
        return task
    }

    @PostMapping
    fun createTask(@RequestBody task: Task): Task {
        return taskRepo.save(task)
    }

    @PutMapping("{id}")
    fun updateTask(
        @PathVariable("id") taskFromDb: Task,
        @RequestBody task: Task
    ):Task{
        BeanUtils.copyProperties(task, taskFromDb, "id")
        return taskRepo.save(taskFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteTask(@PathVariable("id") task: Task) {
        taskRepo.delete(task)
    }

}