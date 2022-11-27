package ru.mephi.pp.dto.undefined.project

class PortfolioProjectDto(
    var userId: Long,
    var name: String,
    var description: String,
    var technologyStack: List<String>
)