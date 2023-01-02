package ru.mephi.pp.service

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.input.profile.SkillInput
import ru.mephi.pp.model.dto.input.profile.toEntity
import ru.mephi.pp.model.dto.info.profile.SkillInfo
import ru.mephi.pp.model.dto.info.profile.toDto

import ru.mephi.pp.model.repository.SkillRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.AccessException
import ru.mephi.pp.utils.exception.NotFoundException

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

    fun createUserSkill(userId: Long, input: SkillInput) {
        val user = userRepo.getUserById(userId)
            ?: throw NotFoundException("User with id=$userId is NOT found")
        user.addToSkills(input.toEntity(user))
        userRepo.save(user)
    }

    fun updateUserSkill(userId: Long, isAdmin: Boolean, skillId: Long, request: SkillInput) {
        skillRepo.getSkillByUserId(skillId)?.let { skill ->
            if (userId != skill.user.id && !isAdmin) {
                throw AccessException("You must be admin, to modify user's (id=$userId) skill with id=$skillId")
            }
            skill.name = request.name
            skill.profLevel = request.profLevel
            skillRepo.save(skill)
        } ?: throw NotFoundException("Skill with id=$skillId is NOT found")
    }

    @Transactional
    fun deleteUserSkill(userId: Long, isAdmin: Boolean, skillId: Long) {
        skillRepo.getSkillByUserId(skillId)?.let { skill ->
            if (userId != skill.user.id && !isAdmin) {
                throw AccessException("You must be admin, to delete user's (id=$userId) skill with id=$skillId")
            }
            skillRepo.removeSkillById(skillId)
        } ?: throw NotFoundException("User with id=$userId is NOT found")
    }
}