package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.project.PortfolioProject
import ru.mephi.pp.repo.PortfolioProjectRepo

@Service
class PortfolioProjectService {

    @Autowired(required = false)
    private lateinit var portfolioProjectCrudRepository: PortfolioProjectRepo

    fun getAll(): MutableIterable<PortfolioProject> = portfolioProjectCrudRepository.findAll()

    fun findById(id: Long) = portfolioProjectCrudRepository.findById(id)

    fun add(portfolioProject: PortfolioProject) = portfolioProjectCrudRepository.save(portfolioProject)

    fun deleteById(id: Long) = portfolioProjectCrudRepository.deleteById(id)
}