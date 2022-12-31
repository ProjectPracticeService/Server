package ru.mephi.pp.model.dto.input.project

import ru.mephi.pp.model.entity.project.Status

class ProjectDto(
    var students: List<Long>,
    var mentorId: Long,
    var tasks: List<Long>,
    var marks: List<Long>,
    var attendance: List<Long>,
    var status: Status
)