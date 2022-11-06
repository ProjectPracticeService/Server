package com.example.PPSystem.System.Project

class Team (_teamId: Int, _memberIds: List<Int>, _mentorId: Int, _status: com.example.PPSystem.System.Project.Status){

    val teamId: Int
    var memberIds: List<Int>
    var mentorId: Int
    var status: com.example.PPSystem.System.Project.Status

    init {
        teamId = _teamId
        memberIds = _memberIds
        mentorId = _mentorId
        status = _status
    }

    fun addMemberById(id: Int):Boolean{
        return true
    }
}