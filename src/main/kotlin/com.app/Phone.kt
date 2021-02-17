package com.app

class Phone(
  private val phoneNumber: String,
  private val code: Int,
) {

  fun sendCode() {
    println("Sending code($code) to Number($phoneNumber)...")
  }
}
