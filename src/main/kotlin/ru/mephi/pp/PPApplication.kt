package ru.mephi.pp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class PPApplication

fun main(args: Array<String>) {
	runApplication<PPApplication>(*args)
}

@Controller
@RequestMapping("api/health")
class Health {
	@GetMapping(value = ["", "/"])
	@ResponseBody
	fun health() = "Good!"
}