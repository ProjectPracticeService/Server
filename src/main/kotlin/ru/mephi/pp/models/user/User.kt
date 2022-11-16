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