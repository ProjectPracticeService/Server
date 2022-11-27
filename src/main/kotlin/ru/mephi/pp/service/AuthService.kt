package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import ru.mephi.pp.dto.request.auth.CreateAccountDto
import ru.mephi.pp.dto.request.auth.LoginDto
import ru.mephi.pp.dto.request.auth.toEntity
import ru.mephi.pp.dto.response.auth.AuthTokenDto
import ru.mephi.pp.dto.response.auth.JwtAuthData
import ru.mephi.pp.dto.response.auth.toEntity
import ru.mephi.pp.exceptions.LoginException
import ru.mephi.pp.exceptions.SignupException
import ru.mephi.pp.repo.TokenRepository
import ru.mephi.pp.repo.UserRepository
import ru.mephi.pp.utils.token.TokenManager
import javax.transaction.Transactional


@Service
class AuthService(
    @Autowired private val userRepo: UserRepository,
    @Autowired private val tokenRepo: TokenRepository,
    @Autowired private val tokenManager: TokenManager
) {
    fun signup(user: CreateAccountDto) {
        if (userRepo.existsByEmail(user.email)) {
            throw SignupException("Failed, email already in use")
        }
        if (userRepo.existsByUsername(user.username)) {
            throw SignupException("Failed, username already in use")
        }
        userRepo.save(user.toEntity())
    }

    @Transactional
    fun login(request: LoginDto): AuthTokenDto {
        return userRepo.getUserByEmailOrUsername(email = request.email, username = request.username)?.let { user ->
            if (user.password != request.password) {
                throw LoginException("Failed, passwords do NOT match")
            }
            val userId = user.id ?: -1
            tokenRepo.removeTokenByUserId(userId)
            AuthTokenDto(
                accessToken = tokenManager.generateAccessToken(user),
                refreshToken = tokenManager.generateRefreshToken(user)
            ).let {
                tokenRepo.save(it.toEntity(userId))
                it
            }
        } ?: run {
            throw LoginException("Failed to find user, username=${request.username}, email=${request.email}")
        }
    }
}