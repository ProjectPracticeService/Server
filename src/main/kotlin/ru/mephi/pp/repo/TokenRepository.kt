package ru.mephi.pp.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.token.Token

@Repository
interface TokenRepository : CrudRepository<Token, Long> {
    fun getTokenByUserId(userId: Long): Token?
    fun removeTokenByUserId(userId: Long)
}