package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.user.Mentor
import ru.mephi.pp.repo.MentorRepo

@RestController
@RequestMapping("mentor")
class MentorController {

    lateinit var mentorRepo:MentorRepo

    @GetMapping("{id}")
    fun getMentor(@PathVariable("id") mentor: Mentor): Mentor {
        return mentor
    }

    @PostMapping
    fun createMentor(@RequestBody mentor: Mentor): Mentor {
        return mentorRepo.save(mentor)
    }

    @PutMapping("{id}")
    fun updateMentor(
        @PathVariable("id") mentorFromDb: Mentor,
        @RequestBody mentor: Mentor
    ):Mentor{
        BeanUtils.copyProperties(mentor, mentorFromDb, "id")
        return mentorRepo.save(mentorFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteMentor(@PathVariable("id") mentor: Mentor) {
        mentorRepo.delete(mentor)
    }

}