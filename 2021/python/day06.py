from aocUtil import *
from collections import Counter

def solve(inputs, days):
    fishCount = dict(Counter(inputs))
    for _ in range(days):
        newDay = {}
        for daysLeft, count in fishCount.items():
            if daysLeft == 0:
                newDay[6] = newDay.get(6, 0) + count
                newDay[8] = count
            else:
                newDay[daysLeft - 1] = newDay.get(daysLeft - 1, 0) + count
        fishCount = newDay
    return sum(fishCount.values())


if __name__ == "__main__":
    input = getIntListInput("06")
    print(f"Part 1: {solve(input, 80)}")
    print(f"Part 2: {solve(input, 256)}")