package com.example.PPSystem.System.Marks

import com.example.PPSystem.System.Profile.Date

class Mark (_id: Int, _mark: com.example.PPSystem.System.Marks.MarkValue, _userId: Int, _pageId: Int, _date: com.example.PPSystem.System.Profile.Date){

    val id: Int
    var mark: com.example.PPSystem.System.Marks.MarkValue
    var userId: Int
    var pageId: Int
    var date: com.example.PPSystem.System.Profile.Date

    init {
        id = _id
        mark = _mark
        userId = _userId
        pageId = _pageId
        date = _date

    }

}