package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.marks.Mark
import ru.mephi.pp.repo.MarkRepo

@Service
class MarkService {

    @Autowired(required = false)
    private lateinit var markCrudRepository: MarkRepo

    fun getAll(): MutableIterable<Mark> = markCrudRepository.findAll()

    fun findById(id: Long) = markCrudRepository.findById(id)

    fun add(mark: Mark) = markCrudRepository.save(mark)

    fun deleteById(id: Long) = markCrudRepository.deleteById(id)
}