package ru.mephi.pp.models.attendance

import ru.mephi.pp.models.profile.Date

class Attendance(_date: Date, _userId: Int, _status: Boolean) {

    var date: Date
    var userId: Int
    var status: Boolean

    init {
        date = _date
        userId = _userId
        status = _status
    }

}