package ru.mephi.pp.controller

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import ru.mephi.pp.model.dto.input.project.PortfolioInput
import ru.mephi.pp.model.dto.info.project.PortfolioInfo
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.service.PortfolioService
import jakarta.validation.Valid

@RestController
@RequestMapping("/api/users/{userId}/portfolio")
class PortfolioController(
    @Autowired private val portfolioService: PortfolioService
) {
    @GetMapping(value = ["", "/"])
    @ResponseBody
    fun getUserPortfolio(@PathVariable userId: String, auth: Authentication): List<PortfolioInfo> {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        return portfolioService.getUserPortfolios(realId)
    }

    @GetMapping("/{portfolioId}")
    @ResponseBody
    fun getUserPortfolio(
        @PathVariable userId: String,
        @PathVariable portfolioId: String,
        auth: Authentication
    ): PortfolioInfo {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        return portfolioService.getUserPortfolio(realId, portfolioId.toLong())
    }

    @PostMapping(value = ["", "/"])
    @ResponseBody
    fun createUserPortfolio(
        @PathVariable userId: String,
        @Valid @RequestBody request: PortfolioInput,
        auth: Authentication
    ) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        portfolioService.createUserPortfolio(realId, request)
    }

    @PutMapping("/{portfolioId}")
    @ResponseBody
    fun updateUserPortfolio(
        @PathVariable userId: String,
        @PathVariable portfolioId: String,
        @Valid @RequestBody request: PortfolioInput,
        auth: Authentication
    ) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        val isAdmin = (auth.authorities as List<*>).contains(Role.Admin)
        portfolioService.updateUserPortfolio(realId, isAdmin, portfolioId.toLong(), request)
    }

    @DeleteMapping("/{portfolioId}")
    @ResponseBody
    fun deleteUserPortfolio(@PathVariable userId: String, @PathVariable portfolioId: String, auth: Authentication) {
        val realId = if (userId == "self") auth.principal as Long else userId.toLong()
        val isAdmin = (auth.authorities as List<*>).contains(Role.Admin)
        portfolioService.deleteUserPortfolio(realId, isAdmin, portfolioId.toLong())
    }
}