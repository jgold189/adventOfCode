import java.lang.Integer.parseInt

object Day03 {

    def getGammaEpsilonRate(inputs: Vector[String]): Int = {
        val posCounts = inputs.map(_.toVector).transpose.map(x => x.groupMapReduce(identity)(_ => 1)(_ + _))
        val gamma = posCounts.foldLeft("")((x, y) => x + y.maxBy(_._2)._1)
        val epsilon = posCounts.foldLeft("")((x, y) => x + y.minBy(_._2)._1)
        parseInt(gamma, 2) * parseInt(epsilon, 2)
    }

    def solveDay(): Int = {
        getGammaEpsilonRate(Util.getInput("03"))
    }

}
