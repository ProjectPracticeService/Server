package ru.mephi.pp.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import ru.mephi.pp.model.dto.input.auth.AccountInput
import ru.mephi.pp.model.dto.input.auth.CredentialsInput
import ru.mephi.pp.model.dto.input.project.PortfolioInput
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.model.entity.user.User
import ru.mephi.pp.model.repository.TokenRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.InputException
import ru.mephi.pp.utils.exception.NotFoundException
import ru.mephi.pp.utils.token.TokenManager

internal class AuthServiceTest {

    private val userRepo = mockk<UserRepository>()
    private val tokenRepo = mockk<TokenRepository>()
    private val tokenManager = mockk<TokenManager>()
    val authService = AuthService(userRepo, tokenRepo, tokenManager)

    @Test
    fun signup() {
        every { userRepo.existsByEmail("test@mail.ru") } returns true

        val data1 = AccountInput("test@mail.ru","123", "Mike", "Biro", "mBir")

        assertThrows<InputException>() {
            authService.signup(data1)
        }

        val data2 = AccountInput("test@mail.ru","123", "Mike", "Biro", "mBir")


//        assertThrows<NotFoundException>() {
//            authService.signup(data1)
//        }

    }

    @Test
    fun signin() {
        every { userRepo.getUserByEmail("test@mail.ru") } returns User(1,"test@mail.ru", "123", setOf(Role.Mentor),
            "Paul", "Conor", "Zaurovich",
            "", 123, null)

        every { userRepo.getUserByEmail("test1@mail.ru") } throws Exception()

        val data1 = CredentialsInput("test@mail.ru", "1234")

        assertThrows<InputException>() {
            authService.signin(data1)
        }

        val data2 = CredentialsInput("test1@mail.ru", "1234")

        assertThrows<Exception>() {
            authService.signin(data2)
        }

    }

    @Test
    fun refresh() {
//        verify { authService.refresh() }
    }

    @Test
    fun signout() {


    }

    @Test
    fun setPassword() {

    }
}