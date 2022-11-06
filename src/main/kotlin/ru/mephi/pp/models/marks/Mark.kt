package ru.mephi.pp.models.marks

import ru.mephi.pp.models.profile.Date

class Mark(_id: Int, _mark: MarkValue, _userId: Int, _pageId: Int, _date: Date) {

    val id: Int
    var mark: MarkValue
    var userId: Int
    var pageId: Int
    var date: Date

    init {
        id = _id
        mark = _mark
        userId = _userId
        pageId = _pageId
        date = _date

    }

}