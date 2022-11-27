package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.dto.undefined.attendance.AttendanceDto
import ru.mephi.pp.models.attendance.Attendance
import ru.mephi.pp.repo.AttendanceRepo

@Service
class AttendanceService {

    @Autowired(required = false)
    private lateinit var attendanceCrudRepository: AttendanceRepo

    @Autowired(required = false)
    private lateinit var modelMapper : ModelMapper

    // заменил MutableIterable на MutableList
    fun getAll(): MutableIterable<AttendanceDto> {
        var attendancesFromRepo = attendanceCrudRepository.findAll()
        var attendance = mutableListOf<AttendanceDto>()
        for(a in attendancesFromRepo){
            attendance.add(convertEntityToDto(a))
        }
        return attendance
    }


    fun findById(id: Long) = convertEntityToDto(attendanceCrudRepository.findById(id).get())



    fun add(attendance: Attendance) = attendanceCrudRepository.save(attendance)

    fun deleteById(id: Long) = attendanceCrudRepository.deleteById(id)


    fun convertEntityToDto(attendance: Attendance) : AttendanceDto {
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var attendanceDTO : AttendanceDto
        attendanceDTO = modelMapper.map(attendance, AttendanceDto::class.java)
        return attendanceDTO
    }

    fun convertDtoToEntity(attendanceDTO: AttendanceDto) : Attendance{
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.LOOSE)
        var attendance : Attendance
        attendance = modelMapper.map(attendanceDTO, Attendance::class.java)
        return attendance
    }


}