object Day01 {

    // To find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
    def massToFuel(mass: Int): Int = {
        (mass / 3) - 2
    }

    def fuelForFuel(currentFuelAmount: Int): Int = {
        val fuel = massToFuel(currentFuelAmount)
        if (fuel > 0) fuel + fuelForFuel(fuel) else 0
    }

    def calcFuel(input: List[String]): Int = {
        input.map(x => massToFuel(x.toInt)).map(x => x + fuelForFuel(x)).reduce((x, y) => x + y)
    }

    def solveDay() = {
        calcFuel(Util.getInput("01.txt"))
    }

}
