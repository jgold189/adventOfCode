import org.scalatest.funsuite.AnyFunSuite

class Day02Test extends AnyFunSuite {
      test("Day02.calcSubPos") {
          val data = Vector("forward 5","down 5","forward 8","up 3","down 8","forward 2")
          assert(Day02.calcSubPos(data) === 150)
      }
}