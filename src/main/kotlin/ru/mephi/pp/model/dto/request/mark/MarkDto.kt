package ru.mephi.pp.model.dto.request.mark

import ru.mephi.pp.model.entity.marks.MarkValue
import java.sql.Timestamp

class MarkDto(
    var userId: Long,
    var mark: MarkValue,
    var date: Timestamp
)