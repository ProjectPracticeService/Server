package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.user.Admin
import ru.mephi.pp.repo.AdminRepo
import ru.mephi.pp.service.AdminService

@RestController
@RequestMapping("admin")
class AdminController {

    @Autowired
    lateinit var adminService: AdminService

    @GetMapping("/all")
    fun getAll() = adminService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        adminService.findById(id)
    }

    @PostMapping
    fun addNewAdmin(@RequestBody admin: Admin){
        adminService.add(admin)
    }

    @DeleteMapping
    fun deleteAdmin(@RequestParam id: Long){
        adminService.deleteById(id)
    }

}