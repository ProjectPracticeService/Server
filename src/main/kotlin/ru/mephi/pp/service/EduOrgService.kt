package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.request.profile.EduOrgRequest
import ru.mephi.pp.model.dto.request.profile.toEntity
import ru.mephi.pp.model.dto.response.profile.EduOrgInfo
import ru.mephi.pp.model.dto.response.profile.toDto
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.repository.EduOrgRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.NotFoundException

@Service
class EduOrgService(
    @Autowired private val eduOrgRepo: EduOrgRepository,
    @Autowired private val userRepo: UserRepository
) {
    fun getEduOrgs(filter: String): List<EduOrgInfo> {
        return eduOrgRepo.findAll().filter {
            it.name.contains(filter)
        }.map { toDtoWrapper(it) }
    }

    fun getEduOrgById(id: Long): EduOrgInfo {
        return eduOrgRepo.getEduOrgById(id)?.let {
            toDtoWrapper(it)
        } ?: throw NotFoundException()
    }

    fun createEduOrg(request: EduOrgRequest) {
        val eduOrg = eduOrgRepo.save(request.toEntity())
        for (userId in request.userIds) {
            userRepo.getUserById(userId)?.let {
                it.eduOrg = eduOrg; userRepo.save(it)
            }
        }
    }

    fun updateEduOrg(eduOrgId: Long, request: EduOrgRequest) {
        eduOrgRepo.getEduOrgById(eduOrgId)?.let { eduOrg ->
            for (user in userRepo.getUsersByEduOrg(eduOrg)) {
                if (!request.userIds.contains(user.id)) {
                    user.eduOrg = null; userRepo.save(user)
                }
            }
            for (userId in request.userIds) {
                userRepo.getUserById(userId)?.let {
                    it.eduOrg = eduOrg; userRepo.save(it)
                }
            }
            eduOrg.name = request.name
            eduOrg.city = request.city
        } ?: run { throw NotFoundException() }
    }

    fun assignEduOrg(eduOrgId: Long, userId: Long) {
        eduOrgRepo.getEduOrgById(eduOrgId)?.let { eduOrg ->
            setUserEduOrg(eduOrg, userId)
        } ?: run { throw NotFoundException() }
    }

    fun deAssignEduOrg(userId: Long) = setUserEduOrg(null, userId)

    private fun setUserEduOrg(eduOrg: EduOrg?, userId: Long) {
        userRepo.getUserById(userId)?.let { user ->
            user.eduOrg = eduOrg; userRepo.save(user)
        } ?: run { throw NotFoundException() }
    }

    private fun toDtoWrapper(eduOrg: EduOrg) = eduOrg.toDto(userRepo.getUsersByEduOrg(eduOrg))
}