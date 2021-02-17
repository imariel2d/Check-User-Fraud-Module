package com.example

import com.app.CodeMaker
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import com.app.User

fun Routing.loginRoute() {
    post("/api/login") {
        val body = call.receiveText()
        val gson = Gson()

        val user = gson.fromJson(body, User::class.java)

        val codeMaker = CodeMaker(user, user.twoFactorAuth)
        codeMaker.saveCodeInMemory()
        codeMaker.sendCodeToDevice()

        val temporaryResponse = gson.toJson(user) // TODO: REMOVE THIS LINE AND MAKE ACTUAL RESPONSE.
        call.respondText(temporaryResponse, ContentType.Application.Json)
    }
}
