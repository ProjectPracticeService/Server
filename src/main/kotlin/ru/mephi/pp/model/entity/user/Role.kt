package ru.mephi.pp.model.entity.user

import org.springframework.security.core.GrantedAuthority

enum class Role(private val value: String) : GrantedAuthority {
    Admin("Admin"),
    Mentor("Mentor"),
    Student("Student");

    override fun getAuthority() = value
}