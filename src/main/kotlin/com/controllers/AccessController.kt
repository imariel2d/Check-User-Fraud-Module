package com.controllers

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import com.app.Code
import com.app.Verifier

fun Routing.accessRoute() {
    post("/api/access") {
        val body = call.receiveText()

        val gson = Gson()
        val code = gson.fromJson(body, Code::class.java)

        val verifier = Verifier()
        println(verifier.verifyCode(code))

        val response = gson.toJson(code)
        call.respondText(response, ContentType.Application.Json)
    }
}
