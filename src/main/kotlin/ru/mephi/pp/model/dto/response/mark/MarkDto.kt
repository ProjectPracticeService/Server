package ru.mephi.pp.model.dto.response.mark

import ru.mephi.pp.model.entity.marks.MarkValue
import java.sql.Timestamp

class MarkDto(
    var projectId: Long,
    var userId: Long,
    var mark: MarkValue,
    var date: Timestamp
)