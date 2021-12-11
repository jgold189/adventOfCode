import java.lang.Integer.parseInt
import scala.annotation.tailrec

object Day03 {

    def getGammaEpsilonRate(inputs: Vector[String]): Int = {
        val posCounts = inputs.map(_.toVector).transpose.map(x => x.groupMapReduce(identity)(_ => 1)(_ + _))
        val gamma = posCounts.foldLeft("")((x, y) => x + y.maxBy(_._2)._1)
        val epsilon = posCounts.foldLeft("")((x, y) => x + y.minBy(_._2)._1)
        parseInt(gamma, 2) * parseInt(epsilon, 2)
    }

    def getBitToKeep(countMap: Map[Char, Int], cmp: Char): Char = {
        cmp match {
            case '1' => if (countMap.values.toSet.size == 1) cmp else countMap.maxBy(_._2)._1
            case '0' => if (countMap.values.toSet.size == 1) cmp else countMap.minBy(_._2)._1
        }
    }

    // 1 is most, 0 is least
    @tailrec
    def filterByBit(remItems: Vector[Vector[Char]], cmp: Char, pos: Int): String = {
        remItems.size match {
            case 1 => remItems.apply(0).mkString
            case _ => {
                val keepBit = getBitToKeep(remItems.transpose.apply(pos).groupMapReduce(identity)(_ => 1)(_ + _), cmp)
                filterByBit(remItems.filter(_.apply(pos) == keepBit), cmp, pos + 1)
            }
        }
    }

    def getLifeSupportRating(inputs: Vector[String]): Int = {
        val vectorizedInput = inputs.map(_.toVector)
        val oxy = filterByBit(vectorizedInput, '1', 0)
        val co2 = filterByBit(vectorizedInput, '0', 0)
        parseInt(oxy, 2) * parseInt(co2, 2)
    }

    def solveDay(): Int = {
        // getGammaEpsilonRate(Util.getInput("03"))
        getLifeSupportRating(Util.getInput("03"))
    }

}
