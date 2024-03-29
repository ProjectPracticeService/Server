package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.project.Project

@Repository
interface TeamRepo: CrudRepository<Project, Long>