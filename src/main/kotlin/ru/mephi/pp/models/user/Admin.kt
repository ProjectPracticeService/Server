package ru.mephi.pp.models.user

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "admins")
class Admin: User()