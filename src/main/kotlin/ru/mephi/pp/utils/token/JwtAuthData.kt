package ru.mephi.pp.utils.token

import org.springframework.security.core.Authentication
import ru.mephi.pp.model.entity.user.Role

class JwtAuthData(
    private var authenticated: Boolean,
    private val userId: Long,
    private val roles: List<Role>
) : Authentication {
    override fun getAuthorities() = roles
    override fun getName() = null
    override fun getCredentials() = null
    override fun getDetails() = null
    override fun getPrincipal() = userId
    override fun isAuthenticated() = authenticated
    override fun setAuthenticated(isAuthenticated: Boolean) {
        authenticated = isAuthenticated
    }
}
