package ru.mephi.pp.model.entity.profile

import ru.mephi.pp.model.entity.user.User
import javax.persistence.*

@Entity
@Table(name = "skills")
class Skill(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,

    @Column(name = "name")
    var name: String,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "level")
    var profLevel: ProficiencyLevel
)