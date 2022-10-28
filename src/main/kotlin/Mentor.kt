class Mentor (_id: Int, _role: Role, _username: String, _password: String, _email: String, _name: String, _sureName: String,
              _status: String, _secondName: String, _telegramId: String, _educationalOrganization: EducationalOrganization)
    :User(_id, _role, _username, _password, _email, _name, _sureName, _status, _secondName, _telegramId){


    var teamsIdsList: List<Int> = listOf()
    var studentsIdsList: List<Int> = listOf()
    var marksPagesIdxsList: List<Int> = listOf()
    var educationalOrganization: EducationalOrganization

    init {
        educationalOrganization = _educationalOrganization
    }

}