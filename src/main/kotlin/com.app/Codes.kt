package com.app

object Codes {
    val codes = mutableListOf<Code>()

    fun insertCode(code: Code) {
        println("Saving ${code.code} in memory...")
        codes.add(code)
    }

    fun removeCode(code: Code) {
        codes.remove(code)
    }
}
