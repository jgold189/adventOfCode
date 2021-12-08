from aocUtil import *
from statistics import mean

def computeFuel(num):
    return round((num * (num + 1)) / 2)

def solve(inputs):
    roughPos = round(mean(inputs))
    potentialFuelCosts = []
    # The answer should be this position or close by so just check 10 spots around it
    for pos in range(roughPos - 4, roughPos + 5):
        fuelCosts = [computeFuel(abs(x - pos)) for x in inputs]
        potentialFuelCosts.append(sum(fuelCosts))
    return min(potentialFuelCosts)


if __name__ == "__main__":
    print(solve(getSingeLineIntInputs("07")))