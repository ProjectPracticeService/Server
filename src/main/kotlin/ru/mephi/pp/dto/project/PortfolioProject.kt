package ru.mephi.pp.dto.project

import ru.mephi.pp.models.user.User
import javax.persistence.*

class PortfolioProject(
    var userId: Long,
    var name: String,
    var description: String,
    var technologyStack: List<String>
)