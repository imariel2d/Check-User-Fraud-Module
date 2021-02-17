package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.loginRoute() {
    post("/api/login") {
        call.respondText("Hello from login", ContentType.Text.Plain)
    }
}
