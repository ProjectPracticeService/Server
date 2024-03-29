package ru.mephi.pp.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import ru.mephi.pp.model.dto.input.profile.SkillInput
import ru.mephi.pp.model.dto.info.profile.SkillInfo
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.service.SkillService

@RestController
@RequestMapping("/api/users/{userId}/skill")
class SkillController(
    @Autowired private val skillService: SkillService
) {
    @GetMapping(value = ["", "/"])
    @ResponseBody
    fun getUserSkill(@PathVariable userId: String, auth: Authentication): List<SkillInfo> {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        return skillService.getUserSkills(realId)
    }

    @GetMapping("/{portfolioId}")
    @ResponseBody
    fun getUserPortfolio(
        @PathVariable userId: String,
        @PathVariable portfolioId: String,
        auth: Authentication
    ): SkillInfo {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        return skillService.getUserSkill(realId)
    }

    @PostMapping(value = ["", "/"])
    @ResponseBody
    fun createUserPortfolio(
        @PathVariable userId: String,
        @Valid @RequestBody request: SkillInput,
        auth: Authentication
    ) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        skillService.createUserSkill(realId, request)
    }

    @PutMapping("/{portfolioId}")
    @ResponseBody
    fun updateUserPortfolio(
        @PathVariable userId: String,
        @PathVariable portfolioId: String,
        @Valid @RequestBody request: SkillInput,
        auth: Authentication
    ) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        val isAdmin = (auth.authorities as List<*>).contains(Role.Admin)
        skillService.updateUserSkill(realId, isAdmin, portfolioId.toLong(), request)
    }

    @DeleteMapping("/{portfolioId}")
    @ResponseBody
    fun deleteUserPortfolio(@PathVariable userId: String, @PathVariable portfolioId: String, auth: Authentication) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        val isAdmin = (auth.authorities as List<*>).contains(Role.Admin)
        skillService.deleteUserSkill(realId, isAdmin, portfolioId.toLong())
    }
}