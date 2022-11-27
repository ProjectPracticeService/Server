package ru.mephi.pp.dto.response.auth

import org.springframework.security.core.Authentication
import ru.mephi.pp.models.user.Role

class JwtAuthData(
    private var authenticated: Boolean,
    private val username: String,
    private val roles: List<Role>
) : Authentication {
    override fun getAuthorities() = roles
    override fun getName() = null
    override fun getCredentials() = null
    override fun getDetails() = null
    override fun getPrincipal() = username
    override fun isAuthenticated() = authenticated
    override fun setAuthenticated(isAuthenticated: Boolean) {
        authenticated = isAuthenticated
    }
}
