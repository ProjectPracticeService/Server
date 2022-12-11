package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.dto.request.profile.EducationalOrganizationDto
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.repo.EducationalOrganizationRepo

@Service
class EducationalOrganizationService {
    @Autowired(required = false)
    private lateinit var eduOrgCrudRepository: EducationalOrganizationRepo


    fun getAll(): MutableList<EducationalOrganizationDto> {
        var educationalOrganizationsFromRepo = eduOrgCrudRepository.findAll()
        var educationalOrganization = mutableListOf<EducationalOrganizationDto>()
        for(a in educationalOrganizationsFromRepo){
            educationalOrganization.add(convertEntityToDto(a))
        }
        return educationalOrganization
    }

    fun findById(id: Long):EducationalOrganizationDto {
        return convertEntityToDto(eduOrgCrudRepository.findById(id).get())
    }

    fun add(eduOrg: EducationalOrganizationDto){
        eduOrgCrudRepository.save(convertDtoToEntity(eduOrg))
    }

    fun deleteById(id: Long) = eduOrgCrudRepository.deleteById(id)

    fun convertEntityToDto(educationalOrganization: EducationalOrganization) : EducationalOrganizationDto {
        val educationalOrganizationDto : EducationalOrganizationDto = EducationalOrganizationDto(educationalOrganization.name, educationalOrganization.city)
        return educationalOrganizationDto
    }

    fun convertDtoToEntity(educationalOrganizationDTO: EducationalOrganizationDto) : EducationalOrganization {
        return EducationalOrganization(name = educationalOrganizationDTO.name, city = educationalOrganizationDTO.city)
    }



}