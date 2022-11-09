package ru.mephi.pp.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.mephi.pp.models.user.Student

interface StudentRepo:JpaRepository <Student, Long>