package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.dto.request.attendance.AttendanceDto
import ru.mephi.pp.models.attendance.Attendance
import ru.mephi.pp.models.project.Project
import ru.mephi.pp.models.user.User
import ru.mephi.pp.repo.AttendanceRepo
import ru.mephi.pp.repo.UserRepository

@Service
class AttendanceService {

    @Autowired(required = false)
    private lateinit var attendanceCrudRepository: AttendanceRepo
    private lateinit var userCrudRepository: UserRepository
//    private lateinit var projectCrudRepository: ProjectRepository

    fun getAll(): MutableList<AttendanceDto> {
        var attendanceFromRepo = attendanceCrudRepository.findAll()
        var attendances = mutableListOf<AttendanceDto>()
        for(a in attendanceFromRepo){
            attendances.add(convertEntityToDto(a))
        }
        return attendances
    }

    fun findById(id: Long) = convertEntityToDto(attendanceCrudRepository.findById(id).get())

//    fun add(attendance: Attendance) = attendanceCrudRepository.save(convertDtoToEntity(attendance))

    fun deleteById(id: Long) = attendanceCrudRepository.deleteById(id)


    fun convertEntityToDto(attendance: Attendance) : AttendanceDto {
        val attendanceDto : AttendanceDto = AttendanceDto(attendance.user.id, attendance.project.id, attendance.date, attendance.status)
        return attendanceDto
    }

//    fun convertDtoToEntity(attendanceDTO: AttendanceDto) : Attendance {
//        val user_: User = userCrudRepository.findById(attendanceDTO.userId!!).get()
//        val project_ : Project =
//        return Attendance(project = , user = user_, date = attendanceDTO.date, status = attendanceDTO.status)
//    }


}