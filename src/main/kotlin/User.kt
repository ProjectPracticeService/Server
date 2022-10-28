open class User(_id: Int, _role: Role, _username: String, _password: String, _email: String,
           _name: String, _sureName: String, _status: String, _secondName: String, _telegramId: String){

    val id: Int
    var role: Role
    var username: String
    var password: String
    var email: String
    var name: String
    var sureName: String
    var status: String
    var secondName: String
    var telegramId: String


    init {
        id = _id
        role = _role
        username = _username
        password = _password
        email = _email
        name = _name
        sureName = _sureName
        status = _status
        secondName = _secondName
        telegramId = _telegramId
    }

    fun validateEmail():Boolean{
        return true
    }

    fun validateTelegramId():Boolean{
        return true
    }

}