import scala.annotation.tailrec

object Day05 {

    case class Points(x: List[Int], y: List[Int])

    def mapLineToPoints(line: String): Vector[(Int, Int)] = {
        val pointArray = line.split(" -> ").map(_.split(",").map(_.toInt)).transpose
        val points = Points(pointArray(0).toList, pointArray(1).toList)
        points match {
            // Vertical
            case points if points.x.forall(_ == points.x.head) => (points.y.min to points.y.max).map((points.x.head, _)).toVector

            // Horizontal
            case points if points.y.forall(_ == points.y.head) => (points.x.min to points.x.max).map((_, points.y.head)).toVector

            // Diagonal
            case _ => {
                val diff = points.x.reduce((x1, x2) => (x1 - x2).abs)
                val xNeg = if (points.x(0) - points.x(1) > 0) -1 else 1
                val yNeg = if (points.y(0) - points.y(1) > 0) -1 else 1
                (0 to diff).map(i => (points.x(0) + i * xNeg, points.y(0) + i * yNeg)).toVector
            }
        }
    }

    def getOverlappingPoints(inputs: Vector[String]) : Int = {
        inputs.flatMap(mapLineToPoints(_)).groupMapReduce(identity)(_ => 1)(_ + _).filter(_._2 >= 2).size
    }

    def solveDay: Int = {
        getOverlappingPoints(Util.getInput("05"))
    }
}
