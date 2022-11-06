package com.example.PPSystem.Spring.controller

import com.example.PPSystem.System.Profile.EducationalOrganization
import com.example.PPSystem.System.User.Role
import com.example.PPSystem.System.User.Student
import com.example.PPSystem.Spring.exceptions.NotFoundException
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

    val eduOrg: com.example.PPSystem.System.Profile.EducationalOrganization =
        com.example.PPSystem.System.Profile.EducationalOrganization(1, "НИЯУ МИФИ", 3)
    val student1: com.example.PPSystem.System.User.Student = com.example.PPSystem.System.User.Student(
        1, com.example.PPSystem.System.User.Role.Student, "Гоша", "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg
    )

    val student2: com.example.PPSystem.System.User.Student = com.example.PPSystem.System.User.Student(
        2, com.example.PPSystem.System.User.Role.Student, "Гоша", "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg
    )

    val student3: com.example.PPSystem.System.User.Student = com.example.PPSystem.System.User.Student(
        3, com.example.PPSystem.System.User.Role.Student, "Гоша", "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg
    )

    private var counter:Int = 4
    private var list: MutableSet<com.example.PPSystem.System.User.Student> = mutableSetOf(student1, student2, student3)

    fun getStudent(@PathVariable id: Int): com.example.PPSystem.System.User.Student {
        return list.stream()
            .filter{it.id == id}
            .findFirst()
            .orElseThrow { NotFoundException() }
    }


    @GetMapping("{id}")
    fun getStudentById(@PathVariable id: Int): com.example.PPSystem.System.User.Student {
        val exception: NotFoundException
        return list.stream()
            .filter{it.id == id}
            .findFirst()
            .orElseThrow { NotFoundException() }
    }

    @PostMapping
    fun createStudent(@RequestBody student: com.example.PPSystem.System.User.Student): com.example.PPSystem.System.User.Student {
        student.id = counter
        counter++
        list.add(student)
        return student
    }

    @PutMapping("{id}")
    fun updateStudentById(@PathVariable id: Int, @RequestBody student: com.example.PPSystem.System.User.Student): com.example.PPSystem.System.User.Student {
        var studentFromDB: com.example.PPSystem.System.User.Student = getStudent(id)
        return studentFromDB
    }
    @DeleteMapping("{id}")
    fun deleteStudentById(@PathVariable id: Int){
            var student: com.example.PPSystem.System.User.Student = getStudent(id)
            list.remove(student)
    }

}