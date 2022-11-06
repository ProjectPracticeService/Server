package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import ru.mephi.pp.exceptions.NotFoundException
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.models.user.Student

@RestController
@RequestMapping("student")
class StudentController {

    val eduOrg: EducationalOrganization = EducationalOrganization(1, "НИЯУ МИФИ", 3)
    val student1: Student = Student(
        1, ru.mephi.pp.models.user.Role.Student, "Гоша", "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg
    )

    val student2: Student = Student(
        2, ru.mephi.pp.models.user.Role.Student, "Гоша", "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg
    )

    val student3: Student = Student(
        3, ru.mephi.pp.models.user.Role.Student, "Гоша", "qwerty123", "gosha@yandex.ru",
        "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg
    )

    private var counter: Int = 4
    private val list: MutableSet<Student> = mutableSetOf(student1, student2, student3)

    fun getStudent(@PathVariable id: Int): Student {
        return list.stream()
            .filter { it.id == id }
            .findFirst()
            .orElseThrow { NotFoundException() }
    }


    @GetMapping("{id}")
    fun getStudentById(@PathVariable id: Int): Student {
        val exception: NotFoundException
        return list.stream()
            .filter { it.id == id }
            .findFirst()
            .orElseThrow { NotFoundException() }
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        student.id = counter
        counter++
        list.add(student)
        return student
    }

    @PutMapping("{id}")
    fun updateStudentById(@PathVariable id: Int, @RequestBody student: Student): Student {
        var studentFromDB: Student = getStudent(id)
        return studentFromDB
    }

    @DeleteMapping("{id}")
    fun deleteStudentById(@PathVariable id: Int) {
        var student: Student = getStudent(id)
        list.remove(student)
    }

}