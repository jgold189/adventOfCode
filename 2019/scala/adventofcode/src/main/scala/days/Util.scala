import scala.io.Source

object Util {
    def getInput(fileName: String): List[String] = {
        val bufferStream = Source.fromFile("./inputs/" + fileName)
        val lineList = bufferStream.getLines().toList
        bufferStream.close()
        lineList
    }

    def getIntCodeInput(fileName: String): List[Int] = {
        getInput(fileName).apply(0).split(",").toList.map(x => x.toInt)
    }

}