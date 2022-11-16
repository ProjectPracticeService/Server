package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.tasks.Task
import ru.mephi.pp.repo.TaskRepo
import ru.mephi.pp.service.TaskService

@RestController
@RequestMapping("task")
class TaskController {

    @Autowired
    lateinit var taskService: TaskService

    @GetMapping("/all")
    fun getAll() = taskService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        taskService.findById(id)
    }

    @PostMapping
    fun addNewTask(@RequestBody task: Task){
        taskService.add(task)
    }

    @DeleteMapping
    fun deleteTask(@RequestParam id: Long){
        taskService.deleteById(id)
    }

}