package ru.mephi.pp.controller

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.model.dto.request.profile.EducationalOrganizationDto
import ru.mephi.pp.service.EducationalOrganizationService

@RestController
@RequestMapping("/educationalorganization")
class EducationOrganizationController {

    @Autowired
    lateinit var educationalOrganizationService: EducationalOrganizationService

    @GetMapping("/all")
    fun getAll() = educationalOrganizationService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long) = educationalOrganizationService.findById(id)


    @PostMapping
    fun addNewEducationalOrganization(@RequestParam name:String, city:Int){
        educationalOrganizationService.add(EducationalOrganizationDto(name, city))
    }

    @DeleteMapping
    fun deleteEducationalOrganization(@RequestParam id: Long){
        educationalOrganizationService.deleteById(id)
    }

}