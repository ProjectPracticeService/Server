package com.example.PPSystem.System.Attendance

import com.example.PPSystem.System.Profile.Date

class Attendance (_date: com.example.PPSystem.System.Profile.Date, _userId: Int, _status: Boolean){

    var date: com.example.PPSystem.System.Profile.Date
    var userId: Int
    var status: Boolean

    init {
        date = _date
        userId = _userId
        status = _status
    }

}