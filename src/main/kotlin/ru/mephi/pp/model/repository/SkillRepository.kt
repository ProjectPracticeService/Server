package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.profile.Skill

@Repository
interface SkillRepository: CrudRepository<Skill, Long> {
    fun getSkillsByUserId(Id: Long): List<Skill>
    fun getSkillByUserId(Id: Long): Skill?
    fun removeSkillById(Id: Long)
}