import scala.annotation.tailrec

object Day04 {

    case class BingoBoard(board: Vector[Set[Int]])
    case class BingoWin(pos: Int, score: Int)

    def getBingoInput(inputs: Vector[String]): (Vector[Int], Vector[BingoBoard]) = {
        val draws = inputs(0).split(",").map(_.toInt).toVector
        val cleanInput = inputs.slice(2, inputs.size).map(_.split(" ").filter(!_.equals("")).map(_.toInt).toVector)
        val boards = cleanInput.sliding(5, 6).map(x => BingoBoard(x.concat(x.transpose).map(_.toSet))).toVector
        (draws, boards)
    }

    // Only need to look at the first five sets to get the board score as columns are just repeats
    def calculateBoardScore(markedNums: Set[Int], bingoBoard: BingoBoard): Int = {
        val boardNumSet = bingoBoard.board.slice(0, 5).reduce((x, y) => x ++ y)
        boardNumSet.diff(markedNums).intersect(boardNumSet).sum
    }

    @tailrec
    def playBingoBoard(draws: Vector[Int], bingoBoard: BingoBoard, pos: Int): BingoWin = {
        val currentDraws = draws.slice(0, pos + 1).toSet
        bingoBoard.board.filter(x => x.intersect(currentDraws).size == 5).size match {
            case x if x > 0 => BingoWin(pos, calculateBoardScore(currentDraws, bingoBoard) * draws(pos))
            case _ => playBingoBoard(draws, bingoBoard, pos + 1)
        }
    }

    def solveDay: Int = {
        val (draws, boards) = getBingoInput(Util.getInput("04"))
        // A board can't win until at least the 5th number
        val finalBoards = boards.map(playBingoBoard(draws, _, 4)).sortBy(_.pos)
        
        // Part 1
        //finalBoards(0).score

        // Part 2
        finalBoards(finalBoards.size - 1).score
    }
}
