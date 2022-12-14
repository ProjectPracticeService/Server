package ru.mephi.pp.model.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.model.entity.attendance.Attendance

@Repository
interface AttendanceRepo: CrudRepository<Attendance, Long>