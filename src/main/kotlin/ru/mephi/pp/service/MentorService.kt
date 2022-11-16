package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.user.Mentor
import ru.mephi.pp.repo.MentorRepo

@Service
class MentorService {

    @Autowired(required = false)
    private lateinit var mentorCrudRepository: MentorRepo

    fun getAll(): MutableIterable<Mentor> = mentorCrudRepository.findAll()

    fun findById(id: Long) = mentorCrudRepository.findById(id)

    fun add(mentor: Mentor) = mentorCrudRepository.save(mentor)

    fun deleteById(id: Long) = mentorCrudRepository.deleteById(id)
}