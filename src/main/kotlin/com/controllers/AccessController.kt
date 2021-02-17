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
        val isCodeValid = verifier.verifyCode(code)

        var response: String = "NO AUTHORIZED"
        if (isCodeValid) {
            response = "AUTHORIZED"
        }

        response = """
                { "message": "$response" }
            """.trimIndent()

        call.respondText(response, ContentType.Application.Json)
    }
}
