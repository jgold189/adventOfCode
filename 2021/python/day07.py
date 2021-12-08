from aocUtil import *
from statistics import median

def solve(inputs):
    pos = round(median(inputs))
    fuelCosts = [abs(x - pos) for x in inputs]
    return sum(fuelCosts)


if __name__ == "__main__":
    print(solve(getSingeLineIntInputs("07")))