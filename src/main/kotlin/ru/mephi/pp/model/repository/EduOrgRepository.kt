package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.user.User

@Repository
interface EduOrgRepository: CrudRepository<EduOrg, Long> {
    fun getEduOrgById(id: Long): EduOrg?
}
