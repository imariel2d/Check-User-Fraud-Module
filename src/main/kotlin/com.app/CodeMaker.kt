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
    val code = Code(this.user.id, this.code)
    Codes.insertCode(code)
  }

  fun sendCodeToDevice() {
    when (this.twoFactorAuthOption) {
      OPTION_PHONE_NUMBER -> {
        val phone = Phone(user.phone, this.code)
        phone.sendCode()
      }
      OPTION_EMAIL -> {
        val email = Email(user.email, this.code)
        email.sendCode()
      }
      else -> print("NOT A VALID AUTH OPTION!")
    }
  }
}
