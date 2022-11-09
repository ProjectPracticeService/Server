package ru.mephi.pp.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.mephi.pp.models.marks.Mark
import ru.mephi.pp.models.user.Admin
import ru.mephi.pp.models.user.Student

interface MarkRepo:JpaRepository <Mark, Long>