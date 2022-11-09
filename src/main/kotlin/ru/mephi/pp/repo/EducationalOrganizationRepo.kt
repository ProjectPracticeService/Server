package ru.mephi.pp.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.mephi.pp.models.profile.EducationalOrganization

interface EducationalOrganizationRepo:JpaRepository <EducationalOrganization, Long>