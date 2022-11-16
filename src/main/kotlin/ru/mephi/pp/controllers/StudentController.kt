package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.user.Student
import ru.mephi.pp.repo.StudentRepo
import ru.mephi.pp.service.StudentService

@RestController
@RequestMapping("student")
class StudentController {

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping("/all")
    fun getAll() = studentService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        studentService.findById(id)
    }

    @PostMapping
    fun addNewStudent(@RequestBody student: Student){
        studentService.add(student)
    }

    @DeleteMapping
    fun deleteStudent(@RequestParam id: Long){
        studentService.deleteById(id)
    }

}