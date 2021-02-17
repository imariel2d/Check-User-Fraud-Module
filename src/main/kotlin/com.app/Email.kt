package com.app

class Email(
  private val email: String,
  private val code: Int,
) {

  fun sendCode() {
    println("Sending code($code) to Email($email)...")
  }
}
