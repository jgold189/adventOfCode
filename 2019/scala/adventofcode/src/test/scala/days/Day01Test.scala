import org.scalatest.funsuite.AnyFunSuite

class Day01Test extends AnyFunSuite {
      test("Day01.massToFuel") {
          assert(Day01.massToFuel(12) === 2)
          assert(Day01.massToFuel(14) === 2)
          assert(Day01.massToFuel(1969) === 654)
          assert(Day01.massToFuel(100756) === 33583)
      }

      test("Day01.fuelForFuel") {
          assert(Day01.fuelForFuel(2) === 0)
          assert(Day01.fuelForFuel(654) === 312)
          assert(Day01.fuelForFuel(33583) === 16763)
      }

      test("Day01.calcFuel") {
          assert(Day01.calcFuel(List("14")) === 2)
          assert(Day01.calcFuel(List("1969")) === 966)
          assert(Day01.calcFuel(List("100756")) === 50346)
      }
}