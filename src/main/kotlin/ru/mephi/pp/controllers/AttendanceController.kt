package ru.mephi.pp.controllers

import org.springframework.web.bind.annotation.*
import org.springframework.beans.BeanUtils
import ru.mephi.pp.models.attendance.Attendance
import ru.mephi.pp.repo.AttendanceRepo

@RestController
@RequestMapping("attendance")
class AttendanceController {

    lateinit var attendanceRepo:AttendanceRepo

    @GetMapping("{id}")
    fun getAttendance(@PathVariable("id") attendance: Attendance): Attendance {
        return attendance
    }

    @PostMapping
    fun createAttendance(@RequestBody attendance: Attendance): Attendance {
        return attendanceRepo.save(attendance)
    }

    @PutMapping("{id}")
    fun updateAttendance(
        @PathVariable("id") attendanceFromDb: Attendance,
        @RequestBody attendance: Attendance
    ):Attendance{
        BeanUtils.copyProperties(attendance, attendanceFromDb, "id")
        return attendanceRepo.save(attendanceFromDb)
    }

    @DeleteMapping("{id}")
    fun deleteAttendance(@PathVariable("id") attendance: Attendance) {
        attendanceRepo.delete(attendance)
    }

}