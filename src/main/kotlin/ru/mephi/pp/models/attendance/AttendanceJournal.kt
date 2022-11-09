package ru.mephi.pp.models.attendance

//бесполезный нужный класс
class AttendanceJournal {

    var attendList: List<Attendance> = listOf()

    fun getUserAttend(userId: Int): List<Attendance> {
        return attendList
    }

}