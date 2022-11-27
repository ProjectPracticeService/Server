package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.repo.UserRepository

@Service
class UserService(
    @Autowired private val userRepo: UserRepository
) { }