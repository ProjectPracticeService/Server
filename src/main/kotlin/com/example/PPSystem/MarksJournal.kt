class MarksJournal{
    var marksIdsList: List<Mark> = listOf()

    //нужны методы для добавления оценок в marksIdsList
    //нельзя хранить все оценки в одной структуре. Будет слишком долгий поиск.
    //посмотреть как реализуется правильный поиск в БД
    //marksIdsList скорее всего не нужен т к это список БД

    fun getUserMarks(userId: Int): List<Mark> {
        return marksIdsList
    }
    fun getAvergeMarkForUser(userId: Int): Int {
        return 3
    }
    fun getMarksFromPage(pageIdx: Int): List<Mark> {
        return marksIdsList
    }

}