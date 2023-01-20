package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.marks.Mark

@Repository
interface MarkRepo: CrudRepository<Mark, Long>{

    fun getMarkByUserIdAndProjectId(userId: Long, projectId: Long): List<Mark>
    fun getMarkByUserId(userId: Long): List<Mark>
}