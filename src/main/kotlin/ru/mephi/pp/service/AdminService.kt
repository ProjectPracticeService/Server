package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.user.Admin
import ru.mephi.pp.repo.AdminRepo

@Service
class AdminService {

    @Autowired(required = false)
    private lateinit var adminCrudRepository: AdminRepo

    fun getAll(): MutableIterable<Admin> = adminCrudRepository.findAll()

    fun findById(id: Long) = adminCrudRepository.findById(id)

    fun add(admin: Admin) = adminCrudRepository.save(admin)

    fun deleteById(id: Long) = adminCrudRepository.deleteById(id)
}