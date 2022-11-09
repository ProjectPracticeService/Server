package ru.mephi.pp.models.user

import javax.persistence.*

@MappedSuperclass
abstract class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    var id: Long? = null

    @Column(name = "role")
    var role: Role? = null

    @Column(name = "username")
    var username: String? = null

    @Column(name = "password")
    var password: String? = null

    @Column(name = "email")
    var email: String? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "sureName")
    var sureName: String? = null

    @Column(name = "status")
    var status: String? = null

    @Column(name = "secondName")
    var secondName: String? = null

    @Column(name = "telegramId")
    var telegramId: String? = null


        fun validateEmail(): Boolean {
        return true
    }

    fun validateTelegramId(): Boolean {
        return true
    }

}
//open class User(
//    _id: Int, _role: Role, _username: String, _password: String, _email: String,
//    _name: String, _sureName: String, _status: String, _secondName: String, _telegramId: String
//) {
//
//    var id: Int
//    var role: Role
//    var username: String
//    var password: String
//    var email: String
//    var name: String
//    var sureName: String
//    var status: String
//    var secondName: String
//    var telegramId: String
//
//
//    init {
//        id = _id
//        role = _role
//        username = _username
//        password = _password
//        email = _email
//        name = _name
//        sureName = _sureName
//        status = _status
//        secondName = _secondName
//        telegramId = _telegramId
//    }
//
//    fun validateEmail(): Boolean {
//        return true
//    }
//
//    fun validateTelegramId(): Boolean {
//        return true
//    }
//
//}