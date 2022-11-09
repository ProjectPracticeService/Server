package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.marks.Mark
import ru.mephi.pp.repo.MarkRepo

@RestController
@RequestMapping("mark")
class MarkController {

    lateinit var markRepo:MarkRepo

    @GetMapping("{id}")
    fun getMark(@PathVariable("id") mark: Mark): Mark {
        return mark
    }

    @PostMapping
    fun createMark(@RequestBody mark: Mark): Mark {
        return markRepo.save(mark)
    }

    @PutMapping("{id}")
    fun updateMark(
        @PathVariable("id") markFromDb: Mark,
        @RequestBody mark: Mark
    ):Mark{
        BeanUtils.copyProperties(mark, markFromDb, "id")
        return markRepo.save(markFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteMark(@PathVariable("id") mark: Mark) {
        markRepo.delete(mark)
    }

}