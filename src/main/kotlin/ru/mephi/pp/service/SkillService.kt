package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.dto.undefined.profile.SkillDto
import ru.mephi.pp.models.profile.Skill
import ru.mephi.pp.repo.SkillRepo

@Service
class SkillService(
    @Autowired private val skillCrudRepository: SkillRepo
) {

    @Autowired(required = false)
    private lateinit var modelMapper : ModelMapper

    fun getAll(): MutableIterable<SkillDto> {
        var skillsFromRepo = skillCrudRepository.findAll()
        var skill = mutableListOf<SkillDto>()
        for(a in skillsFromRepo){
            skill.add(convertEntityToDto(a))
        }
        return skill
    }

    fun findById(id: Long) = convertEntityToDto(skillCrudRepository.findById(id).get())

    fun add(skill: Skill) = skillCrudRepository.save(skill)

    fun deleteById(id: Long) = skillCrudRepository.deleteById(id)

    fun convertEntityToDto(skill: Skill) : SkillDto {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var skillDTO : SkillDto
        skillDTO = modelMapper.map(skill, SkillDto::class.java)
        return skillDTO
    }

    fun convertDtoToEntity(skillDTO: SkillDto) : Skill {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var skill : Skill
        skill = modelMapper.map(skillDTO, Skill::class.java)
        return skill
    }
}