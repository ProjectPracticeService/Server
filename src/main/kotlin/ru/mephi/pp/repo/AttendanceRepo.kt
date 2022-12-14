package ru.mephi.pp.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.attendance.Attendance

@Repository
interface AttendanceRepo: JpaRepository<Attendance, Long>