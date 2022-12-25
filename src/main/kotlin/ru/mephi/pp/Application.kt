package ru.mephi.pp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.mephi.pp.model.dto.ApiResponse
import ru.mephi.pp.model.dto.response.EmptyResponse

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}

@Controller
@RequestMapping("api/health")
class Health {
	@GetMapping(value = ["", "/"])
	fun health() = EmptyResponse("Good!").asResponse()
}