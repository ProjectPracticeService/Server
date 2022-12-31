package ru.mephi.pp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import ru.mephi.pp.model.dto.input.profile.ProfileInput
import ru.mephi.pp.model.dto.info.user.UserInfo
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.service.EduOrgService
import ru.mephi.pp.service.UserService
import javax.validation.Valid


@RestController
@RequestMapping("/api/users")
class UserController(
    @Autowired private val userService: UserService,
    @Autowired private val eduOrgService: EduOrgService
) {
    @GetMapping(value = ["", "/"])
    @ResponseBody
    fun getUsers(@RequestParam filter: String, auth: Authentication): List<UserInfo> {
        return userService.getUsers(filter, auth.principal as Long)
    }

    @GetMapping("/{userId}")
    @ResponseBody
    fun getUserById(@PathVariable userId: String, auth: Authentication): UserInfo {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        return userService.getUserById(realId, auth.principal as Long)
    }

    @PostMapping("/{userId}/roles")
    @PreAuthorize("hasRole('Admin')")
    @ResponseBody
    fun setUserRoles(@PathVariable userId: String, @RequestBody roles: List<String>, auth: Authentication) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        userService.setUserRoles(realId, roles.map { Role.valueOf(it) }.toSet())
    }

    @GetMapping("{userId}/roles")
    @ResponseBody
    fun getUserRoles(@PathVariable userId: String, auth: Authentication): Set<Role>  {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        return userService.getUserRoles(realId)
    }

    @PostMapping("{userId}/profile")
    @ResponseBody
    fun setUserProfile(
        @PathVariable userId: String,
        @Valid @RequestBody request: ProfileInput,
        auth: Authentication
    ) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        if (realId != auth.principal as Long && !(auth.authorities as List<*>).contains(Role.Admin)) {
            throw AccessDeniedException("Admin rights required to change $realId profile")
        }
        userService.setUserProfile(realId, request)
    }

    @PostMapping("{userId}/assign/{eduOrgId}")
    @PreAuthorize("hasRole('Admin')")
    fun assignEduOrg(@PathVariable userId: String, @PathVariable eduOrgId: String, auth: Authentication) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        eduOrgService.assignEduOrg(eduOrgId.toLong(), realId)
    }

    @DeleteMapping("{userId}/assign")
    @PreAuthorize("hasRole('Admin')")
    fun deAssignEduOrg(@PathVariable userId: String, auth: Authentication) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        eduOrgService.deAssignEduOrg(realId)
    }
}