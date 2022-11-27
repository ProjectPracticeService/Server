package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.dto.undefined.task.TaskDto
import ru.mephi.pp.models.tasks.Task
import ru.mephi.pp.repo.TaskRepo

@Service
class TaskService {

    @Autowired(required = false)
    private lateinit var taskCrudRepository: TaskRepo

    @Autowired(required = false)
    private lateinit var modelMapper : ModelMapper

    fun getAll(): MutableIterable<TaskDto> {
        var tasksFromRepo = taskCrudRepository.findAll()
        var task = mutableListOf<TaskDto>()
        for(a in tasksFromRepo){
            task.add(convertEntityToDto(a))
        }
        return task
    }

    fun findById(id: Long) = convertEntityToDto(taskCrudRepository.findById(id).get())

    fun add(task: Task) = taskCrudRepository.save(task)

    fun deleteById(id: Long) = taskCrudRepository.deleteById(id)

    fun convertEntityToDto(task: Task) : TaskDto {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var taskDTO : TaskDto
        taskDTO = modelMapper.map(task, TaskDto::class.java)
        return taskDTO
    }

    fun convertDtoToEntity(taskDTO: TaskDto) : Task {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var task : Task
        task = modelMapper.map(taskDTO, Task::class.java)
        return task
    }
}