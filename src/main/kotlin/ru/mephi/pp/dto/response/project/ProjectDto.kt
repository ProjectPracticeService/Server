package ru.mephi.pp.dto.response.project

import ru.mephi.pp.models.project.Status

class ProjectDto(
    var projectId: Long,
    var students: List<Long>,
    var mentorId: Long,
    var tasks: List<Long>,
    var marks: List<Long>,
    var attendance: List<Long>,
    var status: Status
)