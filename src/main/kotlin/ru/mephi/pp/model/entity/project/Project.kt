package ru.mephi.pp.model.entity.project

import ru.mephi.pp.model.entity.attendance.Attendance
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.model.entity.tasks.Task
import ru.mephi.pp.model.entity.user.User
import javax.persistence.*

@Entity
@Table(name = "projects")
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long,

    @ManyToMany(mappedBy = "projectsAsStudent")
    var students: List<User>,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    var mentor: User,

    @OneToMany(mappedBy = "project")
    var tasks: List<Task>,

    @OneToMany(mappedBy = "project")
    var marks: List<Mark>,

    @OneToMany(mappedBy = "project")
    var attendance: List<Attendance>,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    var status: Status
)