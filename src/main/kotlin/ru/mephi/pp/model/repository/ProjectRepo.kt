package ru.mephi.pp.model.repository

import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.project.Project


@Repository
interface ProjectRepo: CrudRepository<Project, Long> {

    fun getProjectsById(projectId: Long): Project?

}