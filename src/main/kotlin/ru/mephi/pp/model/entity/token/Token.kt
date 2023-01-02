package ru.mephi.pp.model.entity.token

import jakarta.persistence.*

@Entity
@Table(name = "tokens")
class Token(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "user_id")
    var userId: Long,

    @Column(name = "access_token")
    var accessToken: String,

    @Column(name = "refresh_token")
    var refreshToken: String
)