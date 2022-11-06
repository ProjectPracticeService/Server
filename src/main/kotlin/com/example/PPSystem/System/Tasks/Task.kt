package com.example.PPSystem.System.Tasks

import com.example.PPSystem.System.Profile.Date

class Task (_id: Int, _userId: Int, _description: String, _dateFrom: com.example.PPSystem.System.Profile.Date, _dateTo: com.example.PPSystem.System.Profile.Date, _status: com.example.PPSystem.System.Tasks.TaskStatus){

    var id: Int
    var userId: Int
    var description: String
    var dateFrom: com.example.PPSystem.System.Profile.Date
    var dateTo: com.example.PPSystem.System.Profile.Date
    var status: com.example.PPSystem.System.Tasks.TaskStatus

    init {
        id = _id
        userId = _userId
        description = _description
        dateFrom = _dateFrom
        dateTo = _dateTo
        status = _status
    }

}