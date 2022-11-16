package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.project.PortfolioProject
import ru.mephi.pp.repo.PortfolioProjectRepo
import ru.mephi.pp.service.PortfolioProjectService

@RestController
@RequestMapping("portfolioProject")
class PortfolioProjectController {

    @Autowired
    lateinit var portfolioProjectService: PortfolioProjectService

    @GetMapping("/all")
    fun getAll() = portfolioProjectService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        portfolioProjectService.findById(id)
    }

    @PostMapping
    fun addNewPortfolioProject(@RequestBody portfolioProject: PortfolioProject){
        portfolioProjectService.add(portfolioProject)
    }

    @DeleteMapping
    fun deletePortfolioProject(@RequestParam id: Long){
        portfolioProjectService.deleteById(id)
    }

}