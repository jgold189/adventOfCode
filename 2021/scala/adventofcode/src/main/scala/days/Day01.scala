object Day01 {

    def depthChange(input: Vector[Int]): Int = {
        input.sliding(3, 1).map(_.sum).sliding(2, 1).filter(x => x(1) > x(0)).length
    }

    def solveDay() = {
        depthChange(Util.getInput("01.txt").map(_.toInt))
    }

}
