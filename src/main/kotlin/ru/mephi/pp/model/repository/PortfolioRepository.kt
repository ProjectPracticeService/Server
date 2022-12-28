package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.project.Portfolio

@Repository
interface PortfolioRepository: CrudRepository<Portfolio, Long> {
    fun getPortfolioById(id: Long): Portfolio?
    fun getPortfoliosByUserId(id: Long): List<Portfolio>
    fun getPortfolioByUserId(id: Long): Portfolio?
    fun removePortfolioById(id: Long)
}