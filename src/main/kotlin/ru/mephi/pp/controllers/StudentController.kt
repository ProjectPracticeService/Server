package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.user.Student
import ru.mephi.pp.repo.StudentRepo

@RestController
@RequestMapping("student")
class StudentController {

    lateinit var studentRepo:StudentRepo

    @GetMapping("{id}")
    fun getStudent(@PathVariable("id") student: Student): Student {
        return student
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        return studentRepo.save(student)
    }

    @PutMapping("{id}")
    fun updateStudent(
        @PathVariable("id") studentFromDb: Student,
        @RequestBody student: Student
    ):Student{
        BeanUtils.copyProperties(student, studentFromDb, "id")
        return studentRepo.save(studentFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteStudentById(@PathVariable("id") student: Student) {
        studentRepo.delete(student)
    }

}