package ru.mephi.pp.models.tasks

import ru.mephi.pp.models.profile.Date

class Task(_id: Int, _userId: Int, _description: String, _dateFrom: Date, _dateTo: Date, _status: TaskStatus) {

    var id: Int
    var userId: Int
    var description: String
    var dateFrom: Date
    var dateTo: Date
    var status: TaskStatus

    init {
        id = _id
        userId = _userId
        description = _description
        dateFrom = _dateFrom
        dateTo = _dateTo
        status = _status
    }
}