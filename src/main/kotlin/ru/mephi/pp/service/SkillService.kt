package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.profile.Skill
import ru.mephi.pp.repo.SkillRepo

@Service
class SkillService {

    @Autowired(required = false)
    private lateinit var skillCrudRepository: SkillRepo

    fun getAll(): MutableIterable<Skill> = skillCrudRepository.findAll()

    fun findById(id: Long) = skillCrudRepository.findById(id)

    fun add(skill: Skill) = skillCrudRepository.save(skill)

    fun deleteById(id: Long) = skillCrudRepository.deleteById(id)
}