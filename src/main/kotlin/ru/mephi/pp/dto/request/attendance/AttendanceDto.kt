package ru.mephi.pp.dto.request.attendance

import java.util.*
import javax.validation.constraints.NotBlank

class AttendanceDto(
    var userId: Long,
    var date: Date,
    var status: Boolean
)