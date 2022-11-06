package com.example.PPSystem.System.Attendance

class AttendanceJournal {

    var attendList: List<com.example.PPSystem.System.Attendance.Attendance> = listOf()

    fun getUserAttend(userId: Int): List<com.example.PPSystem.System.Attendance.Attendance> {
        return attendList
    }

}