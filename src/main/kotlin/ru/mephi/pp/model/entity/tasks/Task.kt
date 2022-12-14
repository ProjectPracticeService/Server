package ru.mephi.pp.model.entity.tasks

import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.user.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tasks")
class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    var project: Project,

    @ManyToMany(mappedBy = "tasks")
    var assigneesId: List<User>,

    @Column(name = "description")
    var description: String,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateFrom")
    var dateFrom: Date,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateTo")
    var dateTo: Date,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: TaskStatus
)