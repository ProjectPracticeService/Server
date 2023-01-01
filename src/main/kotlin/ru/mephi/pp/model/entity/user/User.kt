package ru.mephi.pp.model.entity.user

import ru.mephi.pp.model.entity.attendance.Attendance
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.profile.Skill
import ru.mephi.pp.model.entity.project.Portfolio
import ru.mephi.pp.model.entity.project.Project
import ru.mephi.pp.model.entity.tasks.Task
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @CollectionTable
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role::class)
    @Column(name = "roles")
    var roles: Set<Role> = setOf(Role.Student),

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
    var eduOrg: EduOrg? = null,

    @OneToMany(mappedBy = "user")
    var skills: MutableList<Skill> = mutableListOf(),

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
    var portfolios: MutableList<Portfolio> = mutableListOf()
) {
    fun addToSkills(skill: Skill) = skills.add(skill)
    fun addToPortfolios(portfolio: Portfolio) = portfolios.add(portfolio)
}