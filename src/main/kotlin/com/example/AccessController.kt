package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.accessRoute() {
    post("/api/access") {
        call.respondText("Hello from access", ContentType.Text.Any)
    }
}
