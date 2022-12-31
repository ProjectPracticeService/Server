package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.input.auth.*
import ru.mephi.pp.model.dto.info.auth.AuthTokenInfo
import ru.mephi.pp.model.dto.info.auth.toDto
import ru.mephi.pp.model.dto.info.auth.toEntity
import ru.mephi.pp.model.repository.TokenRepository
import ru.mephi.pp.model.repository.UserRepository
import ru.mephi.pp.utils.exception.InputException
import ru.mephi.pp.utils.exception.NotFoundException
import ru.mephi.pp.utils.token.TokenManager
import javax.transaction.Transactional


@Service
class AuthService(
    @Autowired private val userRepo: UserRepository,
    @Autowired private val tokenRepo: TokenRepository,
    @Autowired private val tokenManager: TokenManager
) {
    fun signup(user: AccountInput) {
        if (userRepo.existsByEmail(user.email)) {
            throw InputException("Email already in use")
        }
        userRepo.save(user.toEntity())
    }

    @Transactional
    fun signin(request: CredentialsInput): AuthTokenInfo {
        return userRepo.getUserByEmail(request.email)?.let { user ->
            if (user.password != request.password) {
                throw InputException("Passwords do NOT match")
            }
            val userId = user.id ?: -1
            tokenRepo.removeTokenByUserId(userId)
            AuthTokenInfo(
                accessToken = tokenManager.generateAccessToken(user),
                refreshToken = tokenManager.generateRefreshToken(user)
            ).let {
                tokenRepo.save(it.toEntity(userId))
                it
            }
        } ?: run {
            throw NotFoundException("User with email=${request.email} is NOT found")
        }
    }

    fun refresh(refreshToken: String): AuthTokenInfo {
        if (tokenManager.validateRefreshToken(refreshToken)) {
            val claims = tokenManager.getRefreshClaims(refreshToken)
            val token = tokenRepo.getTokenByUserId(claims.subject.toLong())
            if (token?.refreshToken == refreshToken) {
                userRepo.getUserById(token.userId)?.let { user ->
                    token.accessToken = tokenManager.generateAccessToken(user)
                    token.refreshToken = tokenManager.generateRefreshToken(user)
                }
                tokenRepo.save(token)
                return token.toDto()
            }
        }
        throw InputException("Invalid refresh token")
    }

    @Transactional
    fun signout(userId: Long) = tokenRepo.removeTokenByUserId(userId)

    fun setPassword(userId: Long, request: PasswordInput) {
        userRepo.getUserById(userId)?.let { user ->
            if (request.oldPassword != user.password) {
                throw InputException("Passwords do NOT match")
            }
            user.password = request.newPassword
            userRepo.save(user)
        } ?: run { throw NotFoundException("User with id=$userId is NOT found") }
    }
}