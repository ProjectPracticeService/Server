package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.input.project.PortfolioInput
import ru.mephi.pp.model.dto.input.project.toEntity
import ru.mephi.pp.model.dto.info.project.PortfolioInfo
import ru.mephi.pp.model.dto.info.project.toDto
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
        return portfolioRepo.getPortfoliosByUserId(userId).map { it.toDto() }
    }

    fun getUserPortfolio(userId: Long): PortfolioInfo {
        return portfolioRepo.getPortfolioByUserId(userId)?.toDto()
            ?: throw NotFoundException("User with id=$userId is NOT found")
    }

    fun createUserPortfolio(userId: Long, request: PortfolioInput) {
        val user = userRepo.getUserById(userId)
            ?: throw NotFoundException("User with id=$userId is NOT found")
        portfolioRepo.save(request.toEntity(user))
    }

    fun updateUserPortfolio(userId: Long, isAdmin: Boolean, portfolioId: Long, request: PortfolioInput) {
        portfolioRepo.getPortfolioById(portfolioId)?.let { portfolio ->
            if (userId != portfolio.user.id && !isAdmin) {
                throw AccessException("You must be admin, to modify user's (id=$userId) portfolio with id=$portfolioId")
            }
            portfolio.title = request.title
            portfolio.description = request.description
            portfolio.technologyStack = request.technologyStack
            portfolioRepo.save(portfolio)
        } ?: run { throw NotFoundException("User with id=$userId is NOT found") }
    }

    @Transactional
    fun deleteUserPortfolio(userId: Long, isAdmin: Boolean, portfolioId: Long) {
        portfolioRepo.getPortfolioById(portfolioId)?.let { portfolio ->
            if (userId != portfolio.user.id && !isAdmin) {
                throw AccessException("You must be admin, to delete user's (id=$userId) portfolio with id=$portfolioId")
            }
            portfolioRepo.removePortfolioById(portfolioId)
        } ?: run { throw NotFoundException("User with id=$userId is NOT found") }
    }
}