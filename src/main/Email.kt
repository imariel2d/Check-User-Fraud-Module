import java.io.File

class Email(
  private val email: String,
  private val code: Int,
) {

  fun sendCode() {
    val formattedCode = "$email|$code\n"
    val file = File("codes");
    file.appendText(formattedCode)
  }
}
