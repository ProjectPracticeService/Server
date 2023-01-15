package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.info.project.ProjectInfo
import ru.mephi.pp.model.dto.info.project.toDto
import ru.mephi.pp.model.dto.input.profile.ProfileInput
import ru.mephi.pp.model.dto.info.user.UserInfo
import ru.mephi.pp.model.dto.info.user.toDto
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.model.entity.user.User
import ru.mephi.pp.model.repository.PortfolioRepository
import ru.mephi.pp.model.repository.SkillRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.InputException
import ru.mephi.pp.utils.exception.NotFoundException

@Service
class UserService(
    @Autowired private val userRepo: UserRepository,
    @Autowired private val portfolioRepo: PortfolioRepository,
    @Autowired private val skillRepo: SkillRepository
) {

    //GET

    fun getUsers(filter: String, selfId: Long): List<UserInfo> {
        return userRepo.findAll().filter {
            it.name.contains(filter) || it.surname.contains(filter)
                    || it.patronymic?.contains(filter) ?: false
        }.map { toDtoWrapper(it, selfId) }
    }

    fun getUserById(userId: Long, selfId: Long): UserInfo {
        return userRepo.getUserById(userId)?.let { user ->
            toDtoWrapper(user, selfId)
        } ?: run {
            throw NotFoundException("User with id=$userId is NOT found")
        }
    }

    fun getUserRoles(userId: Long): Set<Role> {
        return userRepo.getUserById(userId)?.roles
            ?: throw NotFoundException("User with id=$userId is NOT found")
    }

    fun getUserProjectAsStudent(userId: Long): List<ProjectInfo> {
        return userRepo.getUserById(userId)?.projectsAsStudent?.map { it.toDto() }
            ?: throw NotFoundException("User with id=$userId is NOT found")
    }

    fun getUserProjectAsMentor(userId: Long): List<ProjectInfo> {
        return userRepo.getUserById(userId)?.projectsAsMentor?.map { it.toDto() }
            ?: throw NotFoundException("User with id=$userId is NOT found")
    }

    //POST

    fun setUserRoles(userId: Long, roles: Set<Role>) {
        if (roles.isEmpty()) throw InputException("Roles set is empty, at least one expected")
        userRepo.getUserById(userId)?.let { user ->
            user.roles = roles
            userRepo.save(user)
        } ?: throw NotFoundException("User with id=$userId is NOT found")
    }


    fun setUserProfile(userId: Long, request: ProfileInput) {
        userRepo.getUserById(userId)?.let { user ->
            if (request.name != null) user.name = request.name
            if (request.surname != null) user.surname = request.surname
            if (request.patronymic != null) user.patronymic = request.patronymic
            if (request.status != null) user.status = request.status
            if (request.telegramId != null) user.telegramId = request.telegramId
            userRepo.save(user)
        } ?: throw NotFoundException("User with id=$userId is NOT found")
    }

    private fun toDtoWrapper(user: User, selfId: Long): UserInfo {
        val userId = user.id ?: -1
        return user.toDto(
            userId == selfId,
            portfolioRepo.getPortfoliosByUserId(userId),
            skillRepo.getSkillsByUserId(userId)
        )
    }

}