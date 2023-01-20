package ru.mephi.pp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import ru.mephi.pp.model.dto.info.mark.MarkInfo
import ru.mephi.pp.model.dto.info.profile.EduOrgInfo
import ru.mephi.pp.service.EduOrgService
import ru.mephi.pp.service.MarkService
import ru.mephi.pp.service.UserService

@RestController
@RequestMapping("/api/marks")
class MarkController(
    @Autowired private val markService: MarkService,
    @Autowired private val eduOrgService: EduOrgService
) {

    @GetMapping("/{userId}")
    @ResponseBody
    fun getEduOrgById(@PathVariable userId: String): List<MarkInfo> {
        return markService.getMarkByUserId(userId.toLong())
    }

    @PostMapping("{userId}/project/{projectId}")
    fun getMarkByUserIdAndProjectId(@PathVariable userId: String, @PathVariable projectId: String): List<MarkInfo> {
        return markService.getMarkByUserIdAndProjectId(userId.toLong(), projectId.toLong())
    }

}