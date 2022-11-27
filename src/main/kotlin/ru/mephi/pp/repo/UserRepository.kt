package ru.mephi.pp.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.user.User

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
    fun getUserByEmailOrUsername(email: String, username: String): User?
}