package ru.mephi.pp.service

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import ru.mephi.pp.model.dto.info.project.PortfolioInfo
import ru.mephi.pp.model.dto.input.project.PortfolioInput
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.model.entity.user.User
import ru.mephi.pp.model.repository.PortfolioRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.AccessException

internal class PortfolioServiceTest {

    private val portfolioRepo = mockk<PortfolioRepository>()
    private val userRepo = mockk<UserRepository>()

    private val service = PortfolioService(portfolioRepo, userRepo)

    private val user = User(1,"test@mail.ru", "qwerty", setOf(Role.Mentor),
        "Paul", "Conor", "Zaurovich",
        "", 123, null)

    @BeforeEach
    @Test
    fun setupRepo() {
        every { userRepo.getUserById(1) } returns user
    }

    @Test
    fun getUserPortfolios() {
        val accepted = service.getUserPortfolios(1)
        val expected :List<PortfolioInfo> = listOf()
        assertEquals(accepted, expected)

        every { service.getUserPortfolios(-1) } throws NotFoundException()
    }


    @Test
    fun createUserPortfolio() {
        every {
            service.createUserPortfolio(
                -1,
                PortfolioInput("Android app", "app", listOf())
            )
        } throws NotFoundException()


    }

    @Test
    fun deleteUserPortfolio() {
        assertThrows<Exception>() {
            service.deleteUserPortfolio(1, false, 2)
        }
    }
}