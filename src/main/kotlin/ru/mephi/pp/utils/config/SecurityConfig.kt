package ru.mephi.pp.utils.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import ru.mephi.pp.utils.token.TokenFilter
import kotlin.reflect.typeOf

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(
    @Autowired private val tokenFilter: TokenFilter
) {
    val permittedRoutes = arrayOf("/api/health*", "/api/auth/signup", "/api/auth/signin", "/api/auth/refresh")

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeHttpRequests().requestMatchers(*permittedRoutes).permitAll()
            .anyRequest().authenticated().and()
            .addFilterAfter(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }
}