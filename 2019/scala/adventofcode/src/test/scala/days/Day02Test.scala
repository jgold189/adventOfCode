import org.scalatest.funsuite.AnyFunSuite

class Day02Test extends AnyFunSuite {
      test("Day02.runIntCodeProgram") {
          assert(Day02.runIntCodeProgram(List(1,9,10,3,2,3,11,0,99,30,40,50), 0) === List(3500,9,10,70,2,3,11,0,99,30,40,50))
          assert(Day02.runIntCodeProgram(List(1,0,0,0,99), 0) === List(2,0,0,0,99))
          assert(Day02.runIntCodeProgram(List(2,3,0,3,99), 0) === List(2,3,0,6,99))
          assert(Day02.runIntCodeProgram(List(2,4,4,5,99,0), 0) === List(2,4,4,5,99,9801))
          assert(Day02.runIntCodeProgram(List(1,1,1,4,99,5,6,0,99), 0) === List(30,1,1,4,2,5,6,0,99))
      }
}