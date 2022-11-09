package ru.mephi.pp.models.attendance
import ru.mephi.pp.models.profile.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table (name = "attendance")
class Attendance(

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column (name = "ID")
    var id: Long,

    @Column (name = "Date")
    var date: Date,

    @Column (name = "UserId")
    var userId: Int,

    @Column (name = "Status")
    var status: Boolean

)
