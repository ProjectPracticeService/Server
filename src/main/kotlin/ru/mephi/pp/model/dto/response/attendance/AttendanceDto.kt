package ru.mephi.pp.model.dto.response.attendance

import java.util.*

class AttendanceDto(
    var projectId: Long,
    var userId: Long,
    var date: Date,
    var status: Boolean
)