import scala.annotation.tailrec

object Day02 {

    // Takes the current intCode and the index of the current opCode.
    // Returns the intCode after execution of opCode.
    def intCodeStep(intCode: List[Int], opCodeIndex: Int): List[Int] = {
        val opCode = intCode.apply(opCodeIndex)
        val a = intCode.apply(intCode.apply(opCodeIndex + 1))
        val b = intCode.apply(intCode.apply(opCodeIndex + 2))
        val resultIndex = intCode.apply(opCodeIndex + 3)
        opCode match {
            // Addition
            case 1 => {
                intCode.patch(resultIndex, List(a + b), 1)
            }
            // Multiplication
            case 2 => {
                intCode.patch(resultIndex, List(a * b), 1)
            }
            case _ => throw new Exception("Invalid opCode in intCodeStep: " + opCode)
        }
    }

    @tailrec
    def runIntCodeProgram(input: List[Int], opCodeIndex: Int): List[Int] = {
        val intCode = intCodeStep(input, opCodeIndex)
        if (intCode.apply(opCodeIndex + 4) == 99) intCode else runIntCodeProgram(intCode, opCodeIndex + 4)
    }

    def solveDay(): Int = {
        val initialIntCode = Util.getIntCodeInput("02.txt")
        for (noun <- 0 to 99) {
            for (verb <- 0 to 99) {
                val result = runIntCodeProgram(initialIntCode.patch(1, List(noun, verb), 2), 0).apply(0)
                if (result == 19690720) return 100 * noun + verb
            }
        }
        throw new Exception("No correct result found")
    }

}
