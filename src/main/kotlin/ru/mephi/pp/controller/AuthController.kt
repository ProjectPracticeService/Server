package ru.mephi.pp.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.mephi.pp.model.dto.input.auth.AccessTokenInput
import ru.mephi.pp.model.dto.input.auth.AccountInput
import ru.mephi.pp.model.dto.input.auth.CredentialsInput
import ru.mephi.pp.model.dto.input.auth.PasswordInput
import ru.mephi.pp.model.dto.info.auth.AuthTokenInfo
import ru.mephi.pp.service.AuthService

@Controller
@RequestMapping("api/auth")
class AuthController(
    @Autowired private val authService: AuthService
) {
    @PostMapping("/signup")
    @ResponseBody
    fun signup(@Valid @RequestBody request: AccountInput) {
        authService.signup(request)
    }

    @GetMapping("/signin")
    @ResponseBody
    fun signin(@Valid @RequestBody request: CredentialsInput): AuthTokenInfo {
        return authService.signin(request)
    }

    @GetMapping("/refresh")
    @ResponseBody
    fun refresh(@Valid @RequestBody request: AccessTokenInput): AuthTokenInfo {
        return authService.refresh(request.refreshToken)
    }

    @PostMapping("/signout")
    @ResponseBody
    fun signout(auth: Authentication) {
        authService.signout(auth.principal as Long)
    }

    @PostMapping("/pwd")
    @ResponseBody
    fun setPassword(@Valid @RequestBody request: PasswordInput, auth: Authentication) {
        authService.setPassword(auth.principal as Long, request)
    }
}