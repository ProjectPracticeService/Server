package ru.mephi.pp.model.dto.input.attendance

import java.util.*

class AttendanceDto(
    var userId: Long?,
    var projectId: Long,
    var date: Date,
    var status: Boolean
)

