package ru.mephi.pp.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import ru.mephi.pp.dto.request.auth.CreateAccountDto
import ru.mephi.pp.dto.request.auth.LoginDto
import ru.mephi.pp.dto.response.auth.AuthTokenDto
import ru.mephi.pp.service.AuthService
import javax.validation.Valid

@Controller
@RequestMapping("api/auth")
class AuthController(
    @Autowired private val authService: AuthService
) {
    @PostMapping("/signup")
    @ResponseBody
    fun signup(@Valid @RequestBody request: CreateAccountDto): ResponseEntity<String> {
        authService.signup(request)
        return ResponseEntity.status(HttpStatus.CREATED).body("User successfully created")
    }

    @GetMapping("/login")
    @ResponseBody
    fun login(@Valid @RequestBody request: LoginDto): ResponseEntity<AuthTokenDto> {
        val authToken = authService.login(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(authToken)
    }

    @GetMapping("/self")
    @PreAuthorize("hasAuthority('Student')")
    fun self(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ret.isOk() == true")
    }
}