package com.app

class Verifier {
  fun verifyCode(code: Code): Boolean {
    val removedCode = Codes.removeCode(code)
    return removedCode !== null
  }
}
