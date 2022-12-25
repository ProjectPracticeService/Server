package ru.mephi.pp.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.mephi.pp.model.dto.ApiResponse
import ru.mephi.pp.model.dto.request.auth.AccessTokenRequest
import ru.mephi.pp.model.dto.request.auth.NewAccountRequest
import ru.mephi.pp.model.dto.request.auth.LoginRequest
import ru.mephi.pp.model.dto.response.EmptyResponse
import ru.mephi.pp.service.AuthService
import javax.validation.Valid

@Controller
@RequestMapping("api/auth")
class AuthController(
    @Autowired private val authService: AuthService
) {
    @PostMapping("/signup")
    @ResponseBody
    fun signup(@Valid @RequestBody request: NewAccountRequest): ResponseEntity<ApiResponse> {
        authService.signup(request)
        return EmptyResponse("User successfully created").asResponse()
    }

    @GetMapping("/signin")
    @ResponseBody
    fun signin(@Valid @RequestBody request: LoginRequest): ResponseEntity<ApiResponse> {
        return authService.signin(request).asResponse()
    }

    @GetMapping("/refresh")
    @ResponseBody
    fun refresh(@Valid @RequestBody request: AccessTokenRequest): ResponseEntity<ApiResponse> {
        return authService.refresh(request.refreshToken).asResponse()
    }

    @PostMapping("/signout")
    @ResponseBody
    fun signout(auth: Authentication) {
        authService.signout(auth.principal as Long)
    }
}