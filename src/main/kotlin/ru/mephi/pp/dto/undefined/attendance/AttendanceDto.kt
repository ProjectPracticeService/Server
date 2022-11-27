package ru.mephi.pp.dto.undefined.attendance

import java.util.*

class AttendanceDto(
    var projectId: Long,
    var userId: Long,
    var date: Date,
    var status: Boolean
)