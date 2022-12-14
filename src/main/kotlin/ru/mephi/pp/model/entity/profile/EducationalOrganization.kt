package ru.mephi.pp.model.entity.profile

import ru.mephi.pp.model.entity.user.User
import javax.persistence.*


@Entity
@Table(name = "edu_orgs")
class EducationalOrganization(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "city")
    var city: Int,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eduOrg")
    var users: List<User> = emptyList(),
)
