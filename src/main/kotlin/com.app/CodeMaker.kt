package com.app

class CodeMaker(
  private val user: User,
  private val twoFactorAuthOption: Int,
) {
  private val OPTION_PHONE_NUMBER = 1
  private val OPTION_EMAIL = 2
  private var code: Int

  init {
    val codeGenerator = CodeGenerator()
    val code : Int = codeGenerator.generateCode()
    this.code = code
  }

  fun saveCodeInMemory() {
    // TODO: ACTUALLY IMPLEMENT THIS METHOD.
    println("Save code(${this.code}) to memory.")
  }

  fun sendCodeToDevice() {
    println("Sending code(${this.code}) to device.")

    when (this.twoFactorAuthOption) {
      OPTION_PHONE_NUMBER -> {
        val phone = Phone(user.phone, this.twoFactorAuthOption)
      }
      OPTION_EMAIL -> {
        val email = Email(user.email, this.twoFactorAuthOption)
      }
      else -> print("NOT A VALID AUTH OPTION!")
    }
  }
}
