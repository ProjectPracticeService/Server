package ru.mephi.pp.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.project.PortfolioProject

@Repository
interface PortfolioProjectRepo: CrudRepository<PortfolioProject, Long>