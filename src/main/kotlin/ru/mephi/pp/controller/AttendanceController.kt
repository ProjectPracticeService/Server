package ru.mephi.pp.controller

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import ru.mephi.pp.service.AttendanceService

@RestController
@RequestMapping("/attendance")
class AttendanceController {

    @Autowired
    lateinit var attendanceService: AttendanceService

    @GetMapping("/all")
    fun getAll() = attendanceService.getAll()

    @GetMapping
    fun getById(@RequestParam id:Long){
        attendanceService.findById(id)
    }

//    @PostMapping
//    fun addNewAttendance(@RequestBody attendance: AttendanceDto){
//        attendanceService.add(attendance)
//    }

    @DeleteMapping
    fun deleteAttendance(@RequestParam id: Long){
        attendanceService.deleteById(id)
    }

}