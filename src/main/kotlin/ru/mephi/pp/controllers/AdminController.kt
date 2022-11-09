package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.user.Admin
import ru.mephi.pp.repo.AdminRepo

@RestController
@RequestMapping("admin")
class AdminController {

    lateinit var adminRepo:AdminRepo

    @GetMapping("{id}")
    fun getAdmin(@PathVariable("id") admin: Admin): Admin {
        return admin
    }

    @PostMapping
    fun createAdmin(@RequestBody admin: Admin): Admin {
        return adminRepo.save(admin)
    }

    @PutMapping("{id}")
    fun updateAdmin(
        @PathVariable("id") adminFromDb: Admin,
        @RequestBody admin: Admin
    ):Admin{
        BeanUtils.copyProperties(admin, adminFromDb, "id")
        return adminRepo.save(adminFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteAdmin(@PathVariable("id") admin: Admin) {
        adminRepo.delete(admin)
    }

}