package com.app

import java.util.*
import kotlin.collections.HashMap
import kotlin.concurrent.schedule

object Codes {
    val codes = HashMap<Int, Int>();

    fun insertCode(code: Code) {
        println("Saving ${code.code} in memory...")
        codes[code.userId] = code.code

        Timer("schedule", true).schedule(15000) {
            removeCode(code)
        }
    }

    fun removeCode(code: Code): Int? {
        val userCode = codes[code.userId]

        if (userCode === code.code) {
            println("Removing code.")
            return codes.remove(code.userId)
        } else {
            return null
        }
    }
}
