package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.user.Student
import ru.mephi.pp.repo.StudentRepo

@Service
class StudentService {
    
    @Autowired(required = false)
    private lateinit var studentCrudRepository: StudentRepo

    fun getAll(): MutableIterable<Student> = studentCrudRepository.findAll()

    fun findById(id: Long) = studentCrudRepository.findById(id)

    fun add(student: Student) = studentCrudRepository.save(student)

    fun deleteById(id: Long) = studentCrudRepository.deleteById(id)
}