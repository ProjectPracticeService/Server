package ru.mephi.pp.models.user

import ru.mephi.pp.models.attendance.Attendance
import ru.mephi.pp.models.marks.Mark
import ru.mephi.pp.models.profile.EducationalOrganization
import ru.mephi.pp.models.profile.Skill
import ru.mephi.pp.models.project.PortfolioProject
import ru.mephi.pp.models.project.Project
import ru.mephi.pp.models.tasks.Task
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "username")
    var username: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @CollectionTable
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role::class)
    @Column(name = "roles")
    var roles: List<Role> = listOf(Role.Student),

    @Column(name = "name")
    var name: String,

    @Column(name = "surname")
    var surname: String,

    @Column(name = "patronymic")
    var patronymic: String? = null,

    @Column(name = "status")
    var status: String? = null,

    @Column(name = "telegram_id")
    var telegramId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edu_org")
    var eduOrg: EducationalOrganization? = null,

    @OneToMany(mappedBy = "user")
    var skills: List<Skill> = emptyList(),

    @ManyToMany
    @JoinTable(
        name = "students_projects",
        joinColumns = [JoinColumn(name = "student_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "project_id", referencedColumnName = "id")]
    )
    var projectsAsStudent: List<Project> = emptyList(),

    @ManyToMany
    @JoinTable(
        name = "students_tasks",
        joinColumns = [JoinColumn(name = "student_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "task_id", referencedColumnName = "id")]
    )
    var tasks: List<Task> = emptyList(),

    @OneToMany(mappedBy = "user")
    var marks: List<Mark> = emptyList(),

    @OneToMany(mappedBy = "user")
    var attendance: List<Attendance> = emptyList(),

    @OneToMany(mappedBy = "mentor")
    var projectsAsMentor: List<Project> = emptyList(),

    @OneToMany(mappedBy = "user")
    var portfolioProjects: List<PortfolioProject> = emptyList()
)