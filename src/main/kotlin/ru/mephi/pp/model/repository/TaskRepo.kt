package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.tasks.Task
import java.util.*

@Repository
interface TaskRepo: CrudRepository<Task, Long>{
    fun getTaskByProject(project: Project): List<Task>
    fun getTaskByProjectId(projectId: Long): List<Task>
    fun getTaskByProjectIdAndDateTo(projectId: Long, date: Date): List<Task>
    fun getTaskById(id: Long) : Task?
    fun removeTaskById(id: Long)
}