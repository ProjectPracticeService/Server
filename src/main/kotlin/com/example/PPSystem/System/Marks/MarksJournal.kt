package com.example.PPSystem.System.Marks

class MarksJournal{
    var marksIdsList: List<com.example.PPSystem.System.Marks.Mark> = listOf()

    //нужны методы для добавления оценок в marksIdsList
    //нельзя хранить все оценки в одной структуре. Будет слишком долгий поиск.
    //посмотреть как реализуется правильный поиск в БД
    //marksIdsList скорее всего не нужен т к это список БД

    fun getUserMarks(userId: Int): List<com.example.PPSystem.System.Marks.Mark> {
        return marksIdsList
    }
    fun getAvergeMarkForUser(userId: Int): Int {
        return 3
    }
    fun getMarksFromPage(pageIdx: Int): List<com.example.PPSystem.System.Marks.Mark> {
        return marksIdsList
    }

}