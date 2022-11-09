package ru.mephi.pp.models.user

import ru.mephi.pp.models.profile.EducationalOrganization
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

//class Mentor (_id: Int, _role: com.example.PPSystem.com.example.PPSystem.user.user.Role, _username: String, _password: String, _email: String, _name: String, _sureName: String,
//              _status: String, _secondName: String, _telegramId: String, _educationalOrganization: com.example.PPSystem.profile.EducationalOrganization)
//    :com.example.PPSystem.user.user(_id, _role, _username, _password, _email, _name, _sureName, _status, _secondName, _telegramId){
//
//
//    var teamsIdsList: List<Int> = listOf()
//    var studentsIdsList: List<Int> = listOf()
//    var marksPagesIdxsList: List<Int> = listOf()
//    var educationalOrganization: com.example.PPSystem.profile.EducationalOrganization
//
//    init {
//        educationalOrganization = _educationalOrganization
//    }
//
//}

@Entity
@Table(name = "mentors")
class Mentor: User() {

    @Column(name = "educationalOrganization")
    var educationalOrganization: EducationalOrganization? = null

}