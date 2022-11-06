package ru.mephi.pp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PpSystemApplication

fun main(args: Array<String>) {
	runApplication<PpSystemApplication>(*args)
}
