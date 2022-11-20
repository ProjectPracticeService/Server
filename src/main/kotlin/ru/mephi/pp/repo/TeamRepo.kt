package ru.mephi.pp.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.project.Project

@Repository
interface TeamRepo: CrudRepository<Project, Long>