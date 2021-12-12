import scala.annotation.tailrec
// I don't really know much about this package but I needed a way to merge two Maps adding up the values and this was the simplest way
// Scala only seems to have .merged() on HashMap and groupMapReduce returns a Map and I can't seem to find a simple way to convert a Map to a HashMap
import scalaz._
import Scalaz._

object Day06 {

    def calcFishAge(fishAge: (Int, Long)): Map[Int, Long] = {
        fishAge match {
            case (0, _) => Map(6 -> fishAge._2, 8 -> fishAge._2)
            case _ => Map(fishAge._1 - 1 -> fishAge._2)
        }
    }

    @tailrec
    def calcLanternFishPop(currentPop: Map[Int, Long], maxDay: Int, day: Int): Long = {
        day match {
            case `maxDay` => currentPop.map(_._2).sum
            case _ => {
                val newPop = currentPop.map(calcFishAge(_)).reduce((x, y) => x |+| y)
                calcLanternFishPop(newPop, maxDay, day + 1)
            }
            
        }
    }

    def solveHelper(input: Vector[String], maxDay: Int): Long = {
        val data = input(0).split(",").map(_.toInt).groupMapReduce(identity)(_ => 1L)(_ + _)
        calcLanternFishPop(data, maxDay, 0)
    }

    def solveDay: Long = {
        // Part 1
        //solveHelper(Util.getInput("06"), 80)
        
        // Part 2
        solveHelper(Util.getInput("06"), 256)
    }
}
