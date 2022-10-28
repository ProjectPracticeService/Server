class Team (_teamId: Int, _memberIds: List<Int>, _mentorId: Int, _status: Status){

    val teamId: Int
    var memberIds: List<Int>
    var mentorId: Int
    var status: Status

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