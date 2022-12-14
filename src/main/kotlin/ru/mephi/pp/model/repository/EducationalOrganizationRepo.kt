package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.profile.EducationalOrganization

@Repository
interface EducationalOrganizationRepo: CrudRepository<EducationalOrganization, Long>
