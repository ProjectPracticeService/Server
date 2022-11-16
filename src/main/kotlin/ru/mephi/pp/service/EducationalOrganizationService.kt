package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.repo.EducationalOrganizationRepo

@Service
class EducationalOrganizationService {
    @Autowired(required = false)
    private lateinit var eduOrgCrudRepository: EducationalOrganizationRepo

    fun getAll(): MutableIterable<EducationalOrganization> = eduOrgCrudRepository.findAll()

    fun findById(id: Long) = eduOrgCrudRepository.findById(id)

    fun add(eduOrg: EducationalOrganization) = eduOrgCrudRepository.save(eduOrg)

    fun deleteById(id: Long) = eduOrgCrudRepository.deleteById(id)

}