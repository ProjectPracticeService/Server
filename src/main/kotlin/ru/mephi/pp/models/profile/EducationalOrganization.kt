package ru.mephi.pp.models.profile

import javax.persistence.*


@Table(name = "educationalOrganization")
@Entity
data class EducationalOrganization(
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column (name = "ID")
    var id: Long,

    @Column (name = "name")
    var name: String,

    @Column (name = "city")
    var city: Int,
    )

