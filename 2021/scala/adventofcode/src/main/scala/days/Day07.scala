import scala.annotation.tailrec

object Day07 {

    def getMedian(input: Vector[Int]): Int = {
        val sorted = input.sortWith((x, y) => x < y)
        val length = sorted.size
        length match {
            case x if x % 2 == 0 => sorted.apply(x / 2)
            case x if x % 2 == 1 => (sorted.apply((x - 1) / 2) + sorted.apply((x + 1) / 2)) / 2
        }
    }

    def getMean(input: Vector[Int]): Int = {
        val length = input.size
        input.sum / length
    }

    def computeExpFuel(dist: Int): Int = {
        ((dist * (dist + 1)) / 2)
    }

    def calcFuelMedian(input: Vector[Int]): Int = {
        val median = getMedian(input)
        input.map(_.-(median).abs).sum
    }

    def calcFuelMeanExp(input: Vector[Int]): Int = {
        val mean = getMean(input)
        val roughRange = (mean - 4) to (mean + 4)
        roughRange.map(x => input.map(loc => computeExpFuel(loc.-(x).abs)).sum).min
    }

    def solveDay: Int = {
        // Part 1
        //calcFuelMedian(Util.getOneLineIntInput("07"))

        // Part 2
        calcFuelMeanExp(Util.getOneLineIntInput("07"))
    }
}
