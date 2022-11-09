package ru.mephi.pp.models.project

import ru.mephi.pp.models.user.Student
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "Teams")
class Team(

    @Column (name = "ID")
    var id: Int,

    @ManyToMany
    var members: List<Student>,

    @Column (name = "mentorId")
    var mentorId: Int,

    @Column (name = "status")
    var status: Status,

)