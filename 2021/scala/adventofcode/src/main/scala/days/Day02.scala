import scala.annotation.tailrec

object Day02 {

    // forward 1
    def takeAction(currVal: (Int, Int), action: String): (Int, Int) = {
        val (x, y) = currVal
        val actionSplit = action.split(" ")
        actionSplit match {
            case Array("forward", _) =>(x + actionSplit(1).toInt, y)
            case Array("down", _) => (x, y + actionSplit(1).toInt)
            case Array("up", _) => (x, y - actionSplit(1).toInt)
        }
    }

    def calcSubPos(input: Vector[String]): Int = {
        val (x, y) = input.foldLeft((0, 0))(takeAction)
        x * y
    }

    def solveDay(): Int = {
        calcSubPos(Util.getInput("02"))
    }

}
