package ru.mephi.pp.models.project

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "portfolioProjects")
class PortfolioProject (

    @Column (name = "ID")
    var id: Long,

    @Column (name = "name")
    var name: String,

    @Column (name = "description")
    var description: String,

    @Column (name = "tecnologyStack")
    var tecnologyStack: List<String>,

)