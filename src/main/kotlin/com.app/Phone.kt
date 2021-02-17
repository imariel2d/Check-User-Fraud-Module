package com.app

import java.io.File

class Phone(
  private val phoneNumber: String,
  private val code: Int,
) {

  fun sendCode() {
    val formattedCode = "$phoneNumber|$code\n"
    val file = File("codes");
    file.appendText(formattedCode)
  }
}