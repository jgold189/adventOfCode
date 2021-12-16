import scala.io.Source

object Util {
    def getInput(fileName: String): Vector[String] = {
        val bufferStream = Source.fromFile("./inputs/" + fileName + ".txt")
        val lineList = bufferStream.getLines().toVector
        bufferStream.close()
        lineList
    }

    def getOneLineIntInput(fileName: String): Vector[Int] = {
        getInput(fileName).apply(0).split(",").map(_.toInt).toVector
    }

}