package ru.mephi.pp.dto.mark

import ru.mephi.pp.models.marks.MarkValue
import java.sql.Timestamp

class MarkDto(
    var projectId: Long,
    var userId: Long,
    var mark: MarkValue,
    var date: Timestamp
)