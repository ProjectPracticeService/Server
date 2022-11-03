package com.example.PPSystem.controller

import EducationalOrganization
import Student
import com.example.PPSystem.exceptions.NotFoundException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("student")
class StudentController {

    val eduOrg: EducationalOrganization = EducationalOrganization(1,"НИЯУ МИФИ", 3)
    val student1: Student = Student(
        1,Role.Student, "Гоша" , "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg)

    val student2: Student = Student(
        2,Role.Student, "Гоша" , "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg)

    val student3: Student = Student(
        3,Role.Student, "Гоша" , "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg)

    private var counter:Int = 4
    private var list: MutableSet<Student> = mutableSetOf(student1, student2, student3)

    fun getStudent(@PathVariable id: Int):Student{
        return list.stream()
            .filter{it.id == id}
            .findFirst()
            .orElseThrow { NotFoundException() }
    }


    @GetMapping("{id}")
    fun getStudentById(@PathVariable id: Int): Student {
        val exception: NotFoundException
        return list.stream()
            .filter{it.id == id}
            .findFirst()
            .orElseThrow { NotFoundException() }
    }

    @PostMapping
    fun createStudent(@RequestBody student:Student):Student{
        student.id = counter
        counter++
        list.add(student)
        return student
    }

    @PutMapping("{id}")
    fun updateStudentById(@PathVariable id: Int, @RequestBody student:Student):Student{
        var studentFromDB: Student = getStudent(id)
        return studentFromDB
    }
    @DeleteMapping("{id}")
    fun deleteStudentById(@PathVariable id: Int){
            var student: Student = getStudent(id)
            list.remove(student)
    }

}