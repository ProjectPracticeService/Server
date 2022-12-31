package ru.mephi.pp.model.dto.info.user

import ru.mephi.pp.model.dto.info.profile.SkillInfo
import ru.mephi.pp.model.dto.info.profile.toDto
import ru.mephi.pp.model.dto.info.project.PortfolioInfo
import ru.mephi.pp.model.dto.info.project.ProjectInfo
import ru.mephi.pp.model.dto.info.project.toDto
import ru.mephi.pp.model.entity.profile.Skill
import ru.mephi.pp.model.entity.project.Portfolio
import ru.mephi.pp.model.entity.user.User

data class UserInfo(
    val id: Long,
    val email: String,
    val surname: String,
    val patronymic: String?,
    val status: String?,
    val self: Boolean,
    val skills: List<SkillInfo>,
    val projects: List<ProjectInfo>,
    val portfolioInfo: List<PortfolioInfo>
)

fun User.toDto(
    self: Boolean,
    portfolio: List<Portfolio>,
    skills: List<Skill>
) = UserInfo(
    id = id ?: -1,
    self = self,
    email = email,
    surname = surname,
    patronymic = patronymic,
    status = status,
    skills = skills.map { it.toDto() },
    projects = projectsAsStudent.map { it.toDto() } + projectsAsMentor.map { it.toDto() },
    portfolioInfo = portfolio.map { it.toDto() }
)