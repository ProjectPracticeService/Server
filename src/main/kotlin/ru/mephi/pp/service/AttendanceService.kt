package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.models.attendance.Attendance
import ru.mephi.pp.repo.AttendanceRepo

@Service
class AttendanceService {

    @Autowired(required = false)
    private lateinit var attendanceCrudRepository: AttendanceRepo

    fun getAll(): MutableIterable<Attendance> = attendanceCrudRepository.findAll()

    fun findById(id: Long) = attendanceCrudRepository.findById(id)

    fun add(attendance: Attendance) = attendanceCrudRepository.save(attendance)

    fun deleteById(id: Long) = attendanceCrudRepository.deleteById(id)
}