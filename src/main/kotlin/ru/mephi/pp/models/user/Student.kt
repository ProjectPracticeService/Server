package ru.mephi.pp.models.user

import ru.mephi.pp.models.profile.EducationalOrganization
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table (name = "students")
class Student: User() {

    @Column(name = "projectWishes")
    var projectWishes: String? = null

    @Column(name = "educationalOrganization")
    var educationalOrganization: EducationalOrganization? = null

}