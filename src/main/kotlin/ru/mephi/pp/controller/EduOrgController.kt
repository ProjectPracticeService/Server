package ru.mephi.pp.controller

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import ru.mephi.pp.model.dto.request.profile.EduOrgRequest
import ru.mephi.pp.model.dto.response.profile.EduOrgInfo
import ru.mephi.pp.service.EduOrgService
import javax.validation.Valid

@RestController
@RequestMapping("/api/eduorgs")
class EduOrgController(
    @Autowired private val eduOrgService: EduOrgService
) {
    @GetMapping(value = ["", "/"])
    @ResponseBody
    fun getEduOrgs(@RequestParam filter: String): List<EduOrgInfo> {
        return eduOrgService.getEduOrgs(filter)
    }

    @GetMapping("/{eduOrgId}")
    @ResponseBody
    fun getEduOrgById(@PathVariable eduOrgId: String): EduOrgInfo {
        return eduOrgService.getEduOrgById(eduOrgId.toLong())
    }

    @PostMapping(value = ["", "/"])
    @PreAuthorize("hasRole('Admin')")
    fun createEduOrg(@Valid @RequestBody request: EduOrgRequest) {
        eduOrgService.createEduOrg(request)
    }

    @PutMapping("/{eduOrgId}")
    @PreAuthorize("hasRole('Admin')")
    fun updateEduOrg(@PathVariable eduOrgId: String, @Valid @RequestBody request: EduOrgRequest) {
        eduOrgService.updateEduOrg(eduOrgId.toLong(), request)
    }
}