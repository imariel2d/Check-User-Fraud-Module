import java.io.File

class Verifier(
  private val code: String,
  private val user: User,
  private val twoFactorAuthOption: Int
) {
  private val OPTION_PHONE_NUMBER = 1
  private val OPTION_EMAIL = 2

  fun findCode (file: File, pattern: String, code: String) {
    println("Trying to find the $code with pattern $pattern")
    file.forEachLine{
      if (it.startsWith(pattern) && it.endsWith(code)) {
        println("YOU HAVE BEEN VERIFIED!!!")
      }
    }
  }

  fun verifyCode() {
    val file = File("codes");

    when (twoFactorAuthOption) {
      OPTION_PHONE_NUMBER -> {
        findCode(file, user.phone, code)
      }
      OPTION_EMAIL -> {
        findCode(file, user.email, code)
      }
      else -> print("NOT A VALID AUTH OPTION!")
    }
  }
}
