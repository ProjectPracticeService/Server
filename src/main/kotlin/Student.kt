class Student (_id: Int, _role: Role, _username: String, _password: String, _email: String, _name: String, _sureName: String,
               _status: String, _secondName: String, _telegramId: String, _projectWishes: String, _educationalOrganization: EducationalOrganization)
    :User(_id, _role, _username, _password, _email, _name, _sureName, _status, _secondName, _telegramId) {

    var teamsIdsList: List<Int> = listOf()
    var marksPageIdsList: List<Int> = listOf()
    var skillList: List<Int> = listOf()
    var portfolioProjectsList: List <Int> = listOf()
    var projectWishes: String
    var educationalOrganization: EducationalOrganization

    init {
        projectWishes = _projectWishes
        educationalOrganization = _educationalOrganization
    }

}