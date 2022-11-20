package ru.mephi.pp.models.project

import ru.mephi.pp.models.user.User
import javax.persistence.*

@Entity
@Table(name = "portfolio_projects")
class PortfolioProject(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @ElementCollection(targetClass = String::class)
    @CollectionTable(name = "stacks", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "technology_stack")
    var technologyStack: List<String>
)