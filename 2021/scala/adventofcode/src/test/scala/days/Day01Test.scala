import org.scalatest.funsuite.AnyFunSuite

class Day01Test extends AnyFunSuite {
      test("Day01.depthChange") {
          val data = Vector(199,200,208,210,200,207,240,269,260,263)
          assert(Day01.depthChange(data) === 7)
      }
}