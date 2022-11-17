package ru.mephi.pp.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.user.Admin

@Repository
interface AdminRepo: CrudRepository<Admin, Long>