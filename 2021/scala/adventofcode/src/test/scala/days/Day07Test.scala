import org.scalatest.funsuite.AnyFunSuite

class Day07Test extends AnyFunSuite {
      test("Day07.calcFuel") {
          val data = Vector(16,1,2,0,4,2,7,1,2,14)
          assert(Day07.calcFuelMedian(data) === 37)

          assert(Day07.calcFuelMeanExp(data) === 168)
      }
}