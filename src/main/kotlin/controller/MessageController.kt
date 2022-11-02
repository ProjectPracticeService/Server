package controller

import exceptions.NotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("massage")
class MessageController {

    var list: List<Map<String, Int>> = listOf(mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11))

    @GetMapping
    fun mes(): String {
        return "index"
    }

    @GetMapping("{id}")
    fun mesByid(@PathVariable id: String): Map<String, Int> {
        val exception: NotFoundException
        return list.stream()
            .findFirst()
            .orElseThrow { NotFoundException() }


    }

}
