package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.project.PortfolioProject
import ru.mephi.pp.repo.PortfolioProjectRepo

@RestController
@RequestMapping("portfolioProject")
class PortfolioProjectController {

    lateinit var portfolioProjectRepo:PortfolioProjectRepo

    @GetMapping("{id}")
    fun getPortfolioProject(@PathVariable("id") portfolioProject: PortfolioProject): PortfolioProject {
        return portfolioProject
    }

    @PostMapping
    fun createPortfolioProject(@RequestBody portfolioProject: PortfolioProject): PortfolioProject {
        return portfolioProjectRepo.save(portfolioProject)
    }

    @PutMapping("{id}")
    fun updatePortfolioProject(
        @PathVariable("id") portfolioProjectFromDb: PortfolioProject,
        @RequestBody portfolioProject: PortfolioProject
    ):PortfolioProject{
        BeanUtils.copyProperties(portfolioProject, portfolioProjectFromDb, "id")
        return portfolioProjectRepo.save(portfolioProjectFromDb)
    }

    @DeleteMapping("{id}")
    fun deletePortfolioProject(@PathVariable("id") portfolioProject: PortfolioProject) {
        portfolioProjectRepo.delete(portfolioProject)
    }

}