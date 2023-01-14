package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.info.profile.EduOrgInfo
import ru.mephi.pp.model.dto.info.profile.toDto
import ru.mephi.pp.model.dto.info.project.ProjectInfo
import ru.mephi.pp.model.dto.info.project.toDto
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.project.Status
import ru.mephi.pp.model.repository.EduOrgRepository
import ru.mephi.pp.model.repository.ProjectRepo
import ru.mephi.pp.model.repository.UserRepository

@Service
class ProjectService (
    @Autowired private val projectRepo: ProjectRepo
        ){

    //Info

    fun getProjectsByUserId(userId: Long): List<ProjectInfo> {
        return projectRepo.getProjectsByUserId(userId).map { toDtoWrapper(it) }
    }

    // Для раздела текущие проекты
    fun getProjectsByStatusActiveAndUserId(userId: Long): List<ProjectInfo> {
        return projectRepo.getProjectsByStatusAndUserId(Status.Active, userId)
            .map { toDtoWrapper(it) }
    }

    private fun toDtoWrapper(project: Project) = project.toDto()

}