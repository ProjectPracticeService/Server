package com.example.PPSystem.System.User

import com.example.PPSystem.System.Profile.EducationalOrganization

//data class com.example.PPSystem.com.example.PPSystem.User.User.Student (
//    val id: Int,
//    val role: com.example.PPSystem.com.example.PPSystem.User.User.Role,
//    val username: String,
//    val password: String,
//    val email: String,
//    val name: String,
//    val sureName: String,
//    val status: String,
//    val secondName: String,
//    val telegramId: String,
//    val projectWishes: String,
//    val educationalOrganization: com.example.PPSystem.Profile.EducationalOrganization)


class Student (_id: Int, _role: com.example.PPSystem.System.User.Role, _username: String, _password: String, _email: String, _name: String, _sureName: String,
               _status: String, _secondName: String, _telegramId: String, _projectWishes: String, _educationalOrganization: com.example.PPSystem.System.Profile.EducationalOrganization
)
    : com.example.PPSystem.System.User.User(_id, _role, _username, _password, _email, _name, _sureName, _status, _secondName, _telegramId) {

    var teamsIdsList: List<Int> = listOf()
    var marksPageIdsList: List<Int> = listOf()
    var skillList: List<Int> = listOf()
    var portfolioProjectsList: List <Int> = listOf()
    var projectWishes: String
    var educationalOrganization: com.example.PPSystem.System.Profile.EducationalOrganization

    init {
        projectWishes = _projectWishes
        educationalOrganization = _educationalOrganization
    }


}