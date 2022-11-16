package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.user.Mentor
import ru.mephi.pp.repo.MentorRepo
import ru.mephi.pp.service.MentorService

@RestController
@RequestMapping("mentor")
class MentorController {

    @Autowired
    lateinit var mentorService: MentorService

    @GetMapping("/all")
    fun getAll() = mentorService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        mentorService.findById(id)
    }

    @PostMapping
    fun addNewMentor(@RequestBody mentor: Mentor){
        mentorService.add(mentor)
    }

    @DeleteMapping
    fun deleteMentor(@RequestParam id: Long){
        mentorService.deleteById(id)
    }

}