package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.repo.EducationalOrganizationRepo

@RestController
@RequestMapping("educationalOrganization")
class EducationOrganizationController {

    lateinit var educationalOrganizationRepo:EducationalOrganizationRepo

    @GetMapping("{id}")
    fun getEducationalOrganization(@PathVariable("id") educationalOrganization: EducationalOrganization): EducationalOrganization {
        return educationalOrganization
    }

    @PostMapping
    fun createEducationalOrganization(@RequestBody educationalOrganization: EducationalOrganization): EducationalOrganization {
        return educationalOrganizationRepo.save(educationalOrganization)
    }

    @PutMapping("{id}")
    fun updateEducationalOrganization(
        @PathVariable("id") educationalOrganizationFromDb: EducationalOrganization,
        @RequestBody educationalOrganization: EducationalOrganization
    ):EducationalOrganization{
        BeanUtils.copyProperties(educationalOrganization, educationalOrganizationFromDb, "id")
        return educationalOrganizationRepo.save(educationalOrganizationFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteEducationalOrganization(@PathVariable("id") educationalOrganization: EducationalOrganization) {
        educationalOrganizationRepo.delete(educationalOrganization)
    }

}