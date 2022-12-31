package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.input.profile.SkillRequest
import ru.mephi.pp.model.dto.input.profile.toEntity
import ru.mephi.pp.model.dto.info.profile.SkillInfo
import ru.mephi.pp.model.dto.info.profile.toDto

import ru.mephi.pp.model.repository.SkillRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.AccessException
import ru.mephi.pp.utils.exception.NotFoundException
import javax.transaction.Transactional

@Service
class SkillService(
    @Autowired private val skillRepo: SkillRepository,
    @Autowired private val userRepo: UserRepository
) {
    fun getUserSkills(userId: Long): List<SkillInfo> {
        return skillRepo.getSkillsByUserId(userId).map { it.toDto() }
    }

    fun getUserSkill(userId: Long): SkillInfo {
        return skillRepo.getSkillByUserId(userId)?.toDto()
            ?: throw NotFoundException("User with id=$userId is NOT found")
    }

    fun createUserSkill(userId: Long, request: SkillRequest) {
        val user = userRepo.getUserById(userId)
            ?: throw NotFoundException("User with id=$userId is NOT found")
        skillRepo.save(request.toEntity(user))
    }

    fun updateUserSkill(userId: Long, isAdmin: Boolean, skillId: Long, request: SkillRequest) {
        skillRepo.getSkillByUserId(skillId)?.let { skill ->
            if (userId != skill.user.id && !isAdmin) {
                throw AccessException("You must be admin, to modify user's (id=$userId) skill with id=$skillId")
            }
            skill.name = request.name
            skill.profLevel = request.profLevel
            skillRepo.save(skill)
        } ?: run { throw NotFoundException("Skill with id=$skillId is NOT found") }
    }

    @Transactional
    fun deleteUserSkill(userId: Long, isAdmin: Boolean, skillId: Long) {
        skillRepo.getSkillByUserId(skillId)?.let { skill ->
            if (userId != skill.user.id && !isAdmin) {
                throw AccessException("You must be admin, to delete user's (id=$userId) skill with id=$skillId")
            }
            skillRepo.removeSkillById(skillId)
        } ?: run { throw NotFoundException("User with id=$userId is NOT found") }
    }
}