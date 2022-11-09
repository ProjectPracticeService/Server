package ru.mephi.pp.models.profile

import javax.persistence.*


@Entity
@Table(name = "educationalOrganizations")
data class EducationalOrganization(

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column (name = "")
    var organizationId: Int,

    @Column (name = "")
    var name: String,

    @Column (name = "")
    var city: Int,

    )

