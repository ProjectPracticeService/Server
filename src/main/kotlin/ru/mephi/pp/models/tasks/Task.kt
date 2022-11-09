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

    @Column (name = "")
    var description: String,

    @Column (name = "")
    var dateFrom: Date,

    @Column (name = "")
    var dateTo: Date,

    @Column (name = "")
    var status: TaskStatus
)