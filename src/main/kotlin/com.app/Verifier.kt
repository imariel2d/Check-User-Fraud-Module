package com.app

class Verifier {
  fun verifyCode(code: Code): Boolean {
    Codes.codes.forEach {
      if (it.code === code.code && it.userId === code.userId) {
        return true
      }
    }

    return false
  }
}
