package ru.mephi.pp.model.entity.profile

import javax.persistence.*

@Entity
@Table(name = "edu_orgs")
class EduOrg(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "city")
    var city: Long
)
