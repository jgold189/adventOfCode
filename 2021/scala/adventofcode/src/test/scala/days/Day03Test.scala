import org.scalatest.funsuite.AnyFunSuite

class Day03Test extends AnyFunSuite {
      test("Day03.") {
          val data = Vector("00100","11110","10110","10111","10101","01111","00111","11100","10000","11001","00010","01010")
          assert(Day03.getGammaEpsilonRate(data) === 198)
      }
}