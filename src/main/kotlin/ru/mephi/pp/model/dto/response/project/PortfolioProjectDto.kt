package ru.mephi.pp.model.dto.response.project

class PortfolioProjectDto(
    var userId: Long,
    var name: String,
    var description: String,
    var technologyStack: List<String>
)