package ru.mephi.pp

import org.hibernate.Session
import org.hibernate.SessionFactory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import ru.mephi.pp.models.profile.EducationalOrganization
import java.util.Properties

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class PpSystemApplication

fun main(args: Array<String>) {

	val props = Properties()
	props["hibernate.connection.url"] = "jdbc:postgresql://localhost:5432/testdb"
	props["hibernate.connection.username"] = "root"
	props["hibernate.connection.password"] = "1234"
//	props["hibernate.connection.driver_class"] = "com.mysql.cj.jdbc.Driver"
	props["hibernate.show_sql"] = "true"

	runApplication<PpSystemApplication>(*args)
}
