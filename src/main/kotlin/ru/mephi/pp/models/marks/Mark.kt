package ru.mephi.pp.models.marks

import ru.mephi.pp.models.profile.Date
import ru.mephi.pp.models.user.User
import javax.persistence.*


@Entity
@Table(name = "Marks")
class Mark(

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column (name = "ID")
    var id: Long,

    @Column (name = "mark")
    var mark: MarkValue,

    @OneToMany
    var user: User,

    @Column (name = "pageId")
    var pageId: Int,

    @Column (name = "date")
    var date: Date

    )