package com.example.plugins

import EducationalOrganization
import Student
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class Customer(val id: Int, val firstName: String, val lastName: String)

fun Application.configureRouting() {


    routing {

        get("/") {
            call.respondText("Hello from PPSystem!")
        }

        get("/login"){

        }

        get("/signup"){

        }

        get("/user/{id}") {
            val id = call.parameters["id"]
            val eduOrg: EducationalOrganization = EducationalOrganization(1,"НИЯУ МИФИ", 3)
            val student: Student = Student(
                1,Role.Student, "Гоша" , "qwerty123", "gosha@yandex.ru",
                "Гоша", "Курочкин", "кодер", "Егорович", "@goshka_kod", "mobile-developer", eduOrg)
            val json = Json.encodeToString(student)
            call.respondText(json)
        }

        post("/signup") {
            val student = call.receive<Student>()
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }

    }


}
