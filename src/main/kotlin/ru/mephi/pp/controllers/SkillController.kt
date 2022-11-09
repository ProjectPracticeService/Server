package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.profile.Skill
import ru.mephi.pp.repo.SkillRepo

@RestController
@RequestMapping("skill")
class SkillController {

    lateinit var skillRepo:SkillRepo

    @GetMapping("{id}")
    fun getSkill(@PathVariable("id") skill: Skill): Skill {
        return skill
    }

    @PostMapping
    fun createSkill(@RequestBody skill: Skill): Skill {
        return skillRepo.save(skill)
    }

    @PutMapping("{id}")
    fun updateSkill(
        @PathVariable("id") skillFromDb: Skill,
        @RequestBody skill: Skill
    ):Skill{
        BeanUtils.copyProperties(skill, skillFromDb, "id")
        return skillRepo.save(skillFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteSkill(@PathVariable("id") skill: Skill) {
        skillRepo.delete(skill)
    }

}