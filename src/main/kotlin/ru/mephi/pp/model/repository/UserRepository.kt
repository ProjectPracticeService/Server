package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.user.User

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun existsByEmail(email: String): Boolean
    fun getUserById(id: Long): User?
    fun getUserByEmail(email: String): User?
    fun getUsersByEduOrg(eduOrg: EduOrg): List<User>
}