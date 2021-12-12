import scala.annotation.tailrec

object Day02 {

    // forward 1
    def takeAction(currVal: (Int, Int, Int), action: String): (Int, Int, Int) = {
        val (x, y, aim) = currVal
        val actionSplit = action.split(" ")
        actionSplit match {
            case Array("forward", _) =>(x + actionSplit(1).toInt, y + (aim * actionSplit(1).toInt), aim)
            case Array("down", _) => (x, y, aim + actionSplit(1).toInt)
            case Array("up", _) => (x, y, aim - actionSplit(1).toInt)
        }
    }

    def calcSubPos(input: Vector[String]): Int = {
        val (x, y, _) = input.foldLeft((0, 0, 0))(takeAction)
        x * y
    }

    def solveDay: Int = {
        calcSubPos(Util.getInput("02"))
    }

}
