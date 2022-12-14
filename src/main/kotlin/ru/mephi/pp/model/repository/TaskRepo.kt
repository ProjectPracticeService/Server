package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.tasks.Task
@Repository
interface TaskRepo: CrudRepository<Task, Long>