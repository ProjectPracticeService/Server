package ru.mephi.pp.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.fail
import org.mockito.Mockito
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.model.entity.user.User
import ru.mephi.pp.model.repository.EduOrgRepository
import ru.mephi.pp.model.repository.PortfolioRepository
import ru.mephi.pp.model.repository.SkillRepository
import ru.mephi.pp.model.repository.UserRepository

internal class UserServiceTest {

    val userRepo = Mockito.mock(UserRepository::class.java)
    val portfolioRepo = Mockito.mock(PortfolioRepository::class.java)
    val skillRepo = Mockito.mock(SkillRepository::class.java)
    val userService = UserService(userRepo, portfolioRepo, skillRepo)

    val data = mutableListOf(
        User(1,"test@mail.ru", "qwerty", setOf(Role.Mentor), "Paul", "Conor", "Zaurovich", "", 123, null),
        User(2,"vikulya2004@mail.ru", "12345", setOf(Role.Mentor), "Paulina", "Nemotova", "Olegovna", "", 123, null),
        User(3,"gleb@mail.ru", "pass1!", setOf(Role.Mentor), "Gleb", "Krotov", "Petrov", "", 123, null),
    )

    @BeforeEach
    @Test
    fun setupRepo() {
        Mockito.`when`(userRepo.findAll()).thenReturn(data)
        Mockito.`when`(userRepo.getUserById(1)).thenReturn(data.get(0))
    }

    @Test
    fun `user organization filter in getUsers`() {

        if (userService.getUsers("Gleb", 1).get(0).id != 3.toLong() ||
            userService.getUsers("", 1).size != 3 ||
            userService.getUsers("Paul", 2).size != 2
        ){
            fail("the filter by name is not working correctly")
        }

        if (userService.getUsers("Con", 1).get(0).id != 1.toLong() ||
            userService.getUsers("Con", 1).size != 1 ||
            userService.getUsers("ot", 1).size != 2
        ){
            fail("the filter by surname is not working correctly")
        }

        if (userService.getUsers("Olegovna", 1).get(0).id != 2.toLong() ||
            userService.getUsers("Con", 1).size != 1 ||
            userService.getUsers("ov", 1).size != 3
        ){
            fail("the filter by patronymic is not working correctly")
        }
    }

    @Test
    fun `wrapping an object in getUserById`() {

       val user = data.get(0)

        if(userService.getUserById(1,1).id != user.id){
            fail("id error when wrapping")
        }

        if(userService.getUserById(1,1).patronymic != user.patronymic){
            fail("patronymic error when wrapping")
        }

        if(userService.getUserById(1,1).email != user.email){
            fail("email error when wrapping")
        }

        if(userService.getUserById(1,1).status != user.status){
            fail("status error when wrapping")
        }

        if(userService.getUserById(1,1).surname != user.surname){
            fail("surname error when wrapping")
        }

    }

}