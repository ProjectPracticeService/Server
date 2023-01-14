package ru.mephi.pp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.mephi.pp.model.dto.info.profile.EduOrgInfo
import ru.mephi.pp.model.dto.info.project.ProjectInfo
import ru.mephi.pp.service.EduOrgService
import ru.mephi.pp.service.ProjectService


@RestController
@RequestMapping("/api/projects")
class ProjectController(
    @Autowired private val projectService: ProjectService
) {

    @GetMapping("/projects")
    @ResponseBody
    fun getAllProjects(): List<ProjectInfo> {
        // Изменить передачу параметра userId (Должен стоять ID текущего пользователя)
        return projectService.getProjectsByUserId(1)
    }

    @GetMapping("/ActiveProjects")
    @ResponseBody
    fun getActiveProjects(): List<ProjectInfo> {
        // Изменить передачу параметра userId (Должен стоять ID текущего пользователя)
        return projectService.getProjectsByStatusActiveAndUserId(1)
    }


}