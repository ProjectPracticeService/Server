package ru.mephi.pp.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.mephi.pp.service.UserService


@RestController
@RequestMapping("/api/users")
class UserController(
    @Autowired private val userService: UserService
) { }