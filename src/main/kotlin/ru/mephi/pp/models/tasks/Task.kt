package ru.mephi.pp.models.tasks

import ru.mephi.pp.models.profile.Date
import ru.mephi.pp.models.user.User
import javax.persistence.*

@Entity
@Table(name = "tasks")
class Task(
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "ID")
    var id: Long,

    @ManyToOne
    var user: User,

    @Column (name = "description")
    var description: String,

    @Column (name = "dateFrom")
    var dateFrom: Date,

    @Column (name = "dateTo")
    var dateTo: Date,

    @Column (name = "status")
    var status: TaskStatus
)