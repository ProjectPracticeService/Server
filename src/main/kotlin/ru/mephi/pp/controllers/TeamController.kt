package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.project.Team
import ru.mephi.pp.repo.TeamRepo

@RestController
@RequestMapping("team")
class TeamController {

    lateinit var teamRepo:TeamRepo

    @GetMapping("{id}")
    fun getTeam(@PathVariable("id") team: Team): Team {
        return team
    }

    @PostMapping
    fun createTeam(@RequestBody team: Team): Team {
        return teamRepo.save(team)
    }

    @PutMapping("{id}")
    fun updateTeam(
        @PathVariable("id") teamFromDb: Team,
        @RequestBody team: Team
    ):Team{
        BeanUtils.copyProperties(team, teamFromDb, "id")
        return teamRepo.save(teamFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteTeam(@PathVariable("id") team: Team) {
        teamRepo.delete(team)
    }

}