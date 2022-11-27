package ru.mephi.pp.utils.token

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.filter.GenericFilterBean
import ru.mephi.pp.dto.response.auth.JwtAuthData
import ru.mephi.pp.models.user.Role
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@Component
class TokenFilter(
    @Autowired private val tokenManager: TokenManager
): GenericFilterBean() {
    private val authHeaderName = "Authorization"
    private val authHeaderStart = "Bearer "

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        (request as HttpServletRequest).getHeader(authHeaderName)?.let { header ->
            if (StringUtils.hasText(header) && header.startsWith(authHeaderStart)) {
                val token = header.substring(authHeaderStart.length)
                if (tokenManager.validateAccessToken(token)) {
                    println("mHeader = $header")
                    tokenManager.getAccessClaims(token).let { claims ->
                        val authData = JwtAuthData(
                            username = claims.subject,
                            roles = claims.get("roles", List::class.java).map { Role.valueOf(it as String) },
                            authenticated = true
                        )
                        SecurityContextHolder.getContext().authentication = authData
                    }
                }
            }
        }
        chain.doFilter(request, response)
    }
}