package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.request.project.PortfolioProjectDto
import ru.mephi.pp.model.entity.project.PortfolioProject
import ru.mephi.pp.model.repository.PortfolioProjectRepo

@Service
class PortfolioProjectService {

    @Autowired(required = false)
    private lateinit var portfolioProjectCrudRepository: PortfolioProjectRepo

    @Autowired(required = false)
    private lateinit var modelMapper : ModelMapper

    fun getAll(): MutableIterable<PortfolioProjectDto> {
        var portfolioProjectsFromRepo = portfolioProjectCrudRepository.findAll()
        var portfolioProject = mutableListOf<PortfolioProjectDto>()
        for(a in portfolioProjectsFromRepo){
            portfolioProject.add(convertEntityToDto(a))
        }
        return portfolioProject
    }

    fun findById(id: Long) = convertEntityToDto(portfolioProjectCrudRepository.findById(id).get())

    fun add(portfolioProject: PortfolioProject) = portfolioProjectCrudRepository.save(portfolioProject)

    fun deleteById(id: Long) = portfolioProjectCrudRepository.deleteById(id)

    fun convertEntityToDto(portfolioProject: PortfolioProject) : PortfolioProjectDto {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var portfolioProjectDTO : PortfolioProjectDto
        portfolioProjectDTO = modelMapper.map(portfolioProject, PortfolioProjectDto::class.java)
        return portfolioProjectDTO
    }

    fun convertDtoToEntity(portfolioProjectDTO: PortfolioProjectDto) : PortfolioProject {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var portfolioProject : PortfolioProject
        portfolioProject = modelMapper.map(portfolioProjectDTO, PortfolioProject::class.java)
        return portfolioProject
    }
}