package ru.mephi.pp.dto.request.mark

import ru.mephi.pp.models.marks.MarkValue
import java.sql.Timestamp

class MarkDto(
    var userId: Long,
    var mark: MarkValue,
    var date: Timestamp
)