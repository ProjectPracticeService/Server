package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.dto.undefined.profile.EducationalOrganizationDto
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.repo.EducationalOrganizationRepo

@Service
class EducationalOrganizationService {
    @Autowired(required = false)
    private lateinit var eduOrgCrudRepository: EducationalOrganizationRepo

    @Autowired(required = false)
    private lateinit var modelMapper : ModelMapper

    fun getAll(): MutableIterable<EducationalOrganizationDto> {
        var educationalOrganizationsFromRepo = eduOrgCrudRepository.findAll()
        var educationalOrganization = mutableListOf<EducationalOrganizationDto>()
        for(a in educationalOrganizationsFromRepo){
            educationalOrganization.add(convertEntityToDto(a))
        }
        return educationalOrganization
    }

    fun findById(id: Long) = convertEntityToDto(eduOrgCrudRepository.findById(id).get())

    fun add(eduOrg: EducationalOrganization) = eduOrgCrudRepository.save(eduOrg)

    fun deleteById(id: Long) = eduOrgCrudRepository.deleteById(id)

    fun convertEntityToDto(educationalOrganization: EducationalOrganization) : EducationalOrganizationDto {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var educationalOrganizationDTO : EducationalOrganizationDto
        educationalOrganizationDTO = modelMapper.map(educationalOrganization, EducationalOrganizationDto::class.java)
        return educationalOrganizationDTO
    }

    fun convertDtoToEntity(educationalOrganizationDTO: EducationalOrganizationDto) : EducationalOrganization {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var educationalOrganization : EducationalOrganization
        educationalOrganization = modelMapper.map(educationalOrganizationDTO, EducationalOrganization::class.java)
        return educationalOrganization
    }

}