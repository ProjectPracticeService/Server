package ru.mephi.pp.model.entity.project

import ru.mephi.pp.model.entity.user.User
import javax.persistence.*

@Entity
@Table(name = "portfolios")
class Portfolio(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String,

    @ElementCollection(targetClass = String::class)
    @CollectionTable(name = "stacks", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "technology_stack")
    var technologyStack: List<String>
)