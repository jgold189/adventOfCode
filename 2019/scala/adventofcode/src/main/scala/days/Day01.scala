object Day01 {

    // To find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
    def massToFuel(mass: String): Int = {
        (mass.toInt / 3) - 2
    }

    def calcFuel(input: List[String]): Int = {
        input.map(massToFuel).reduce((x, y) => x + y)
    }

    def solveDay() = {
        calcFuel(Util.getInput("01.txt"))
    }

}
