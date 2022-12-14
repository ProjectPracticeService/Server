package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.request.attendance.AttendanceDto
import ru.mephi.pp.model.entity.attendance.Attendance
import ru.mephi.pp.model.repository.AttendanceRepo
import ru.mephi.pp.model.repository.UserRepository

@Service
class AttendanceService {

    @Autowired(required = false)
    private lateinit var attendanceCrudRepository: AttendanceRepo
    private lateinit var userCrudRepository: UserRepository
//    private lateinit var projectCrudRepository: ProjectRepository

    fun getAll(): MutableList<ru.mephi.pp.model.dto.request.attendance.AttendanceDto> {
        var attendanceFromRepo = attendanceCrudRepository.findAll()
        var attendances = mutableListOf<ru.mephi.pp.model.dto.request.attendance.AttendanceDto>()
        for(a in attendanceFromRepo){
            attendances.add(convertEntityToDto(a))
        }
        return attendances
    }

    fun findById(id: Long) = convertEntityToDto(attendanceCrudRepository.findById(id).get())

//    fun add(attendance: Attendance) = attendanceCrudRepository.save(convertDtoToEntity(attendance))

    fun deleteById(id: Long) = attendanceCrudRepository.deleteById(id)


    fun convertEntityToDto(attendance: Attendance) : ru.mephi.pp.model.dto.request.attendance.AttendanceDto {
        val attendanceDto : ru.mephi.pp.model.dto.request.attendance.AttendanceDto =
            ru.mephi.pp.model.dto.request.attendance.AttendanceDto(
                attendance.user.id,
                attendance.project.id,
                attendance.date,
                attendance.status
            )
        return attendanceDto
    }

//    fun convertDtoToEntity(attendanceDTO: AttendanceDto) : Attendance {
//        val user_: User = userCrudRepository.findById(attendanceDTO.userId!!).get()
//        val project_ : Project =
//        return Attendance(project = , user = user_, date = attendanceDTO.date, status = attendanceDTO.status)
//    }


}