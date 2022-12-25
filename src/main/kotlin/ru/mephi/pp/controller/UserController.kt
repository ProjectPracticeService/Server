package ru.mephi.pp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.mephi.pp.model.entity.user.User
import ru.mephi.pp.service.UserService


@RestController
@RequestMapping("/api/users")
class UserController(
    @Autowired private val userService: UserService
) {
    @GetMapping("/")
    fun getAll() = userService.getAll()

//    @GetMapping
//    fun getById(@RequestParam id:Long){
//        userService.findById(id)
//    }

    @PostMapping
    fun addNewUser(@RequestBody user: User){
        userService.add(user)
    }

    @DeleteMapping
    fun deleteUser(@RequestParam id: Long){
        userService.deleteById(id)
    }

}