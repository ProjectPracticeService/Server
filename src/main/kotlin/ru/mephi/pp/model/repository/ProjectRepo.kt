package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.project.Status
import ru.mephi.pp.model.entity.user.User

@Repository
interface ProjectRepo: CrudRepository<Project, Long> {

    fun getProjectsByUserId(userId: Long) : List<Project>
    fun getProjectsByStatusAndUserId(status: Status, userId: Long): List<Project>

}