package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.user.User

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
    fun getUserById(id: Long): User?
    fun getUserByEmailOrUsername(email: String, username: String): User?
}