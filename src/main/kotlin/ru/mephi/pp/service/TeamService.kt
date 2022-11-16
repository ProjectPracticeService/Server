package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.project.Team
import ru.mephi.pp.repo.TeamRepo

@Service
class TeamService {

    @Autowired(required = false)
    private lateinit var teamCrudRepository: TeamRepo

    fun getAll(): MutableIterable<Team> = teamCrudRepository.findAll()

    fun findById(id: Long) = teamCrudRepository.findById(id)

    fun add(team: Team) = teamCrudRepository.save(team)

    fun deleteById(id: Long) = teamCrudRepository.deleteById(id)
}