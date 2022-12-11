package ru.mephi.pp.models.attendance
import ru.mephi.pp.models.project.Project
import ru.mephi.pp.models.user.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "attendance")
class Attendance(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    var project: Project,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    var date: Date,

    @Column(name = "status")
    var status: Boolean
)
