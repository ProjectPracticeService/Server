package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.request.project.PortfolioRequest
import ru.mephi.pp.model.dto.request.project.toEntity
import ru.mephi.pp.model.dto.response.project.PortfolioInfo
import ru.mephi.pp.model.dto.response.project.toDto
import ru.mephi.pp.model.repository.PortfolioRepository
import ru.mephi.pp.model.repository.UserRepository
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
        return portfolioRepo.getPortfolioByUserId(userId)?.toDto() ?: throw NotFoundException()
    }

    fun createUserPortfolio(userId: Long, request: PortfolioRequest) {
        val user = userRepo.getUserById(userId) ?: throw NotFoundException()
        portfolioRepo.save(request.toEntity(user))
    }

    fun updateUserPortfolio(userId: Long, isAdmin: Boolean, portfolioId: Long, request: PortfolioRequest) {
        portfolioRepo.getPortfolioById(portfolioId)?.let { portfolio ->
            if (userId != portfolio.user.id && !isAdmin) throw NotFoundException()
            portfolio.title = request.title
            portfolio.description = request.description
            portfolio.technologyStack = request.technologyStack
            portfolioRepo.save(portfolio)
        } ?: run { throw NotFoundException() }
    }

    @Transactional
    fun deleteUserPortfolio(userId: Long, isAdmin: Boolean, portfolioId: Long) {
        portfolioRepo.getPortfolioById(portfolioId)?.let { portfolio ->
            if (userId != portfolio.user.id && !isAdmin) throw NotFoundException()
            portfolioRepo.removePortfolioById(portfolioId)
        } ?: run { throw NotFoundException() }
    }
}