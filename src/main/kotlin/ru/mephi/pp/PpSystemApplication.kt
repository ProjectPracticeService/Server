package ru.mephi.pp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import java.util.Properties

@SpringBootApplication
class PpSystemApplication

fun main(args: Array<String>) {
	runApplication<PpSystemApplication>(*args)
}
