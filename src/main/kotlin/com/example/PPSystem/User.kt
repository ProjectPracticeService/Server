


abstract class User(){


    lateinit var role: Role
    lateinit var username: String
    lateinit var password: String
    lateinit var email: String
    lateinit var name: String
    lateinit var sureName: String
    lateinit var status: String
    lateinit var secondName: String
    lateinit var telegramId: String


    fun validateEmail():Boolean{
        return true
    }

    fun validateTelegramId():Boolean{
        return true
    }

}