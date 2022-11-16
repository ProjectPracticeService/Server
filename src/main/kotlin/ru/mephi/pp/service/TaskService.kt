package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.tasks.Task
import ru.mephi.pp.repo.TaskRepo

@Service
class TaskService {

    @Autowired(required = false)
    private lateinit var taskCrudRepository: TaskRepo

    fun getAll(): MutableIterable<Task> = taskCrudRepository.findAll()

    fun findById(id: Long) = taskCrudRepository.findById(id)

    fun add(task: Task) = taskCrudRepository.save(task)

    fun deleteById(id: Long) = taskCrudRepository.deleteById(id)
}