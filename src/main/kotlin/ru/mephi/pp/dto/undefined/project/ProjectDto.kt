package ru.mephi.pp.dto.undefined.project

import ru.mephi.pp.models.project.Status

class ProjectDto(
    var students: List<Long>,
    var mentorId: Long,
    var tasks: List<Long>,
    var marks: List<Long>,
    var attendance: List<Long>,
    var status: Status
)