import scala.io.Source

object Util {
    def getInput(fileName: String): Vector[String] = {
        val bufferStream = Source.fromFile("./inputs/" + fileName)
        val lineList = bufferStream.getLines().toVector
        bufferStream.close()
        lineList
    }

}