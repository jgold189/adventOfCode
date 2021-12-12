object Main extends App {

    val days = Map(
        1 -> Day01.solveDay(),
        2 -> Day02.solveDay(),
        3 -> Day03.solveDay(),
        4 -> Day04.solveDay()
        )

    if (args.length != 1) {
        println("Program takes only one arg for the day to run")
    } else {
        var dayArg : Option[Int] = None
        try {
            dayArg = Some(args(0).toInt)
        } catch {
            case e: Exception => dayArg = None
        }

        dayArg match {
            case None => println("Input could not be converted to int")
            case Some(x) if days.contains(x) => println(days.get(x).get)  
            case _ => println("Day has not been completed yet or is an invalid day")
        }
    }
    
}
