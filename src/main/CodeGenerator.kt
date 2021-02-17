import kotlin.math.floor
import kotlin.math.roundToInt

class CodeGenerator {
  fun generateCode () : Int {
    return floor(Math.random() * 100).roundToInt()
  }
}
