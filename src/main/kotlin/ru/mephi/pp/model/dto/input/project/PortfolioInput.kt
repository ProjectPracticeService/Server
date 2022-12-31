package ru.mephi.pp.model.dto.input.project

import ru.mephi.pp.model.entity.project.Portfolio
import ru.mephi.pp.model.entity.user.User
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class PortfolioInput(
    @field:NotBlank
    val title: String,

    @field:NotBlank
    val description: String,

    @field:NotEmpty
    val technologyStack: List<@NotBlank String>
)

fun PortfolioInput.toEntity(user: User) = Portfolio(
    id = null,
    user = user,
    title = title,
    description = description,
    technologyStack = technologyStack,
)