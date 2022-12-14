package ru.mephi.pp.model.dto.request.attendance

import java.util.*
import javax.validation.constraints.NotBlank

class AttendanceDto(
    var userId: Long?,
    var projectId: Long,
    var date: Date,
    var status: Boolean
)

