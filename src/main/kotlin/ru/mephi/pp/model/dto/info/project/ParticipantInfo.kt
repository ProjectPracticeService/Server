package ru.mephi.pp.model.dto.info.project

import ru.mephi.pp.model.entity.user.User

data class ParticipantInfo(
    val userId: Long,
    val surname: String
)

fun User.toDto() = ParticipantInfo(
    userId = id ?: -1,
    surname = surname
)