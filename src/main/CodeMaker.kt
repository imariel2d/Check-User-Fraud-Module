class CodeMaker(
  private val user: User,
  private val twoFactorAuthOption: Number,
) {
  private val OPTION_PHONE_NUMBER = 1
  private val OPTION_EMAIL = 2

  fun saveCodeInMemory() {
    // TODO: ACTUALLY CREATE THIS METHOD.
  }

  fun sendCodeToDevice() {
    val codeGenerator = CodeGenerator()
    val code : Int = codeGenerator.generateCode()

    when (twoFactorAuthOption) {
      OPTION_PHONE_NUMBER -> {
        val phone = Phone(user.phone, code)
      }
      OPTION_EMAIL -> {
        val email = Email(user.email, code)
      }
      else -> print("NOT A VALID AUTH OPTION!")
    }
  }
}
