package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.repo.EducationalOrganizationRepo
import ru.mephi.pp.service.EducationalOrganizationService

@RestController
@RequestMapping("/educationalorganization")
class EducationOrganizationController {

    @Autowired
    lateinit var educationalOrganizationService: EducationalOrganizationService

    @GetMapping("/all")
    fun getAll() = educationalOrganizationService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        educationalOrganizationService.findById(id)
    }

    @PostMapping
    fun addNewEducationalOrganization(@RequestBody educationalOrganization: EducationalOrganization){
        educationalOrganizationService.add(educationalOrganization)
    }

    @DeleteMapping
    fun deleteEducationalOrganization(@RequestParam id: Long){
        educationalOrganizationService.deleteById(id)
    }

}