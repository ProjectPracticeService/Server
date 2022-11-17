package ru.mephi.pp.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.attendance.Attendance
import ru.mephi.pp.models.user.Admin
import ru.mephi.pp.models.user.Student
@Repository
interface AttendanceRepo: CrudRepository<Attendance, Long>