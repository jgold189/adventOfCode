import org.scalatest.funsuite.AnyFunSuite

class Day04Test extends AnyFunSuite {
      test("Day04.getBingoInput") {
          val data = Vector("00100","11110","10110","10111","10101","01111","00111","11100","10000","11001","00010","01010")
          assert(Day04.getGammaEpsilonRate(data) === 198)
      }
}