package ru.mephi.pp.model.dto.response.project

import ru.mephi.pp.model.entity.project.Portfolio

data class PortfolioInfo(
    val id: Long,
    val title: String,
    val description: String,
    val technologyStack: List<String>
)

fun Portfolio.toDto() = PortfolioInfo(
    id = id ?: -1,
    title = title,
    description = description,
    technologyStack = technologyStack
)
