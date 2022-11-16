package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.profile.Skill
import ru.mephi.pp.models.profile.ProficiencyLevel
import ru.mephi.pp.repo.SkillRepo
import ru.mephi.pp.service.SkillService

@RestController
@RequestMapping("skill")
class SkillController {

    @Autowired(required = true)
    var skillService: SkillService = SkillService()

    var count: Long = 0

    @GetMapping("/all")
    fun getAll() = Skill(2, "C++", "exp", ProficiencyLevel.Proficiency)

    @GetMapping("/test")
    fun getTest() = "test"

    @GetMapping
    fun getById(@RequestParam id:Long){
        skillService.findById(id)
    }

    @PostMapping
    fun addNewSkill(@RequestBody skill: Skill){
        skillService.add(Skill(count, "C++", "exp", ProficiencyLevel.Proficiency))
        count++
    }

    @DeleteMapping
    fun deleteSkill(@RequestParam id: Long){
        skillService.deleteById(id)
    }

}