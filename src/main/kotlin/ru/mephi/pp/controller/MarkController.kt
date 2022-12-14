package ru.mephi.pp.controller

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.service.MarkService

@RestController
@RequestMapping("mark")
class MarkController {

    @Autowired
    lateinit var markService: MarkService

    @GetMapping("/all")
    fun getAll() = "markService.getAll()"

    @GetMapping
    fun getById(@RequestParam id:Long){
        markService.findById(id)
    }

    @PostMapping
    fun addNewMark(@RequestBody mark: Mark){
        markService.add(mark)
    }

    @DeleteMapping
    fun deleteMark(@RequestParam id: Long){
        markService.deleteById(id)
    }

}