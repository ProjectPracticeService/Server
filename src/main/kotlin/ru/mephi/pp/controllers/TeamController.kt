package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.project.Project
import ru.mephi.pp.service.TeamService

@RestController
@RequestMapping("team")
class TeamController {

    @Autowired
    lateinit var teamService: TeamService

    @GetMapping("/all")
    fun getAll() = teamService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        teamService.findById(id)
    }

    @PostMapping
    fun addNewTeam(@RequestBody team: Project){
        teamService.add(team)
    }

    @DeleteMapping
    fun deleteTeam(@RequestParam id: Long){
        teamService.deleteById(id)
    }

}