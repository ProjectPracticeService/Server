package ru.mephi.pp.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.mephi.pp.models.tasks.Task

interface TaskRepo:JpaRepository <Task, Long>