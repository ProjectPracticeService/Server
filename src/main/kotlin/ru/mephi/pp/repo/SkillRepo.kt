package ru.mephi.pp.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.mephi.pp.models.profile.Skill

interface SkillRepo:JpaRepository <Skill, Long>