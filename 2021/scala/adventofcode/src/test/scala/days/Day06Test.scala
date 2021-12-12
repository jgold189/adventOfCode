import org.scalatest.funsuite.AnyFunSuite

class Day06Test extends AnyFunSuite {
      test("Day06.solveHelper") {
          val data = Vector("3,4,3,1,2")

          assert(Day06.solveHelper(data, 18) === 26)

          // Part 1 Test
          assert(Day06.solveHelper(data, 80) === 5934)

          // Part 2 Test
          assert(Day06.solveHelper(data, 256) === 26984457539L)
      }
}