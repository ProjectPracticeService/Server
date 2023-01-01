package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.input.project.PortfolioInput
import ru.mephi.pp.model.dto.input.project.toEntity
import ru.mephi.pp.model.dto.info.project.PortfolioInfo
import ru.mephi.pp.model.dto.info.project.toDto
import ru.mephi.pp.model.entity.project.Portfolio
import ru.mephi.pp.model.repository.PortfolioRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.AccessException
import ru.mephi.pp.utils.exception.NotFoundException
import javax.transaction.Transactional

@Service
class PortfolioService(
    @Autowired private val portfolioRepo: PortfolioRepository,
    @Autowired private val userRepo: UserRepository
) {
    fun getUserPortfolios(userId: Long): List<PortfolioInfo> {
        return userRepo.getUserById(userId)?.portfolios?.map { it.toDto() }
            ?: throw NotFoundException("User with id=$userId is NOT found")
    }

    fun getUserPortfolio(userId: Long, portfolioId: Long): PortfolioInfo {
        return getUserPortfolioWrapper(userId, portfolioId).toDto()
    }

    fun createUserPortfolio(userId: Long, input: PortfolioInput) {
        val user = userRepo.getUserById(userId)
            ?: throw NotFoundException("User with id=$userId is NOT found")
        portfolioRepo.save(input.toEntity(user))
    }

    fun updateUserPortfolio(userId: Long, isAdmin: Boolean, portfolioId: Long, request: PortfolioInput) {
        val portfolio = getUserPortfolioWrapper(userId, portfolioId).apply {
            title = request.title
            description = request.description
            technologyStack = request.technologyStack
        }
        portfolioRepo.save(portfolio)
    }

    @Transactional
    fun deleteUserPortfolio(userId: Long, isAdmin: Boolean, portfolioId: Long) {
        val portfolio = getUserPortfolioWrapper(userId, portfolioId)
        if (userId != portfolio.user.id && !isAdmin) {
            throw AccessException("You must be admin, to delete user's (id=$userId) portfolio with id=$portfolioId")
        }
        portfolioRepo.removePortfolioById(portfolioId)
    }

     private fun getUserPortfolioWrapper(userId: Long, portfolioId: Long): Portfolio {
         return userRepo.getUserById(userId)?.let { user ->
             user.portfolios.firstOrNull { it.id == portfolioId }
                 ?: throw NotFoundException("Portfolio with id=$portfolioId is NOT found")
         } ?: throw NotFoundException("User with id=$userId is NOT found")
     }
}