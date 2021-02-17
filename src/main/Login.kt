class Login(
  val user: User,
  val twoFactorAuthOption: Int
) {

  init {
    println(user.name + " " + "is logging in.")
  }

  fun generateAccess() {
    val codeMaker = CodeMaker(user, twoFactorAuthOption)
  }
}
