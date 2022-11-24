package ru.mephi.pp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import java.util.Properties

@SpringBootApplication
class PpSystemApplication

fun main(args: Array<String>) {

	val props = Properties()
	props["hibernate.connection.url"] = "jdbc:postgresql://localhost:8080/testdb"
	props["hibernate.connection.username"] = "db"
	props["hibernate.connection.password"] = "Password"
//	props["hibernate.connection.driver_class"] = "com.mysql.cj.jdbc.Driver"
	props["hibernate.show_sql"] = "true"


	runApplication<PpSystemApplication>(*args)
}
