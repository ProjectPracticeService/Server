package ru.mephi.pp.models.profile

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "skills")
class Skill(

    @Column (name = "ID")
    var id: Long,

    @Column (name = "name")
    var name: String,

    @Column (name = "experience")
    var experience: String,

    @Column (name = "proficiencyLevel")
    var proficiencyLevel: ProficiencyLevel

)