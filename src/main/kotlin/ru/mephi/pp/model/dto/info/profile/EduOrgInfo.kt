package ru.mephi.pp.model.dto.info.profile

import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.user.User

data class EduOrgInfo(
    val id: Long,
    val name: String,
    val city: Long,
    val userIds: List<Long>
)

fun EduOrg.toDto(users: List<User>) = EduOrgInfo(
    id = id ?: -1,
    name = name,
    city = city,
    userIds = users.map { it.id ?: -1 }
)
