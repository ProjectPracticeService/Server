package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.info.mark.MarkInfo
import ru.mephi.pp.model.dto.info.mark.toDto
import ru.mephi.pp.model.dto.info.user.UserInfo
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.model.repository.*
import ru.mephi.pp.utils.exception.NotFoundException

@Service
class MarkService (
    @Autowired private val userRepo: UserRepository,
    @Autowired private val projectRepo: ProjectRepo,
    @Autowired private val markRepo: MarkRepo
        ){

    fun getMarkByUserIdAndProjectId(userId: Long, projectId: Long): List<MarkInfo> {
        return markRepo.getMarkByUserIdAndProjectId(userId, projectId).map { it.toDto() }
    }

    fun getMarkByUserId(userId: Long): List<MarkInfo> {
        return markRepo.getMarkByUserId(userId).map { it.toDto() }
    }

}