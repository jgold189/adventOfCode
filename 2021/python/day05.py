from aocUtil import *

def getAllCoords(line):
    coords = []
    firstPoint, secondPoint = [x.split(",") for x in line.split(" -> ")]
    x1, y1 = [int(x) for x in firstPoint]
    x2, y2 = [int(x) for x in secondPoint]
    if x1 == x2:
        for i in range(min(y1, y2), max(y1, y2) + 1):
            coords.append(f"{x1},{i}")
    elif y1 == y2:
        for i in range(min(x1, x2), max(x1, x2) + 1):
            coords.append(f"{i},{y1}")
    else:
        diff = abs(x1 - x2)
        xNeg = -1 if x1 - x2 > 0 else 1
        yNeg = -1 if y1 - y2 > 0 else 1
        for i in range(0, diff + 1):
            coords.append(f"{x1 + (i * xNeg)},{y1 + (i * yNeg)}")
    
    return coords

def solve(inputs):
    vents = {}
    for line in inputs:
        for point in getAllCoords(line):
            vents[point] = vents.get(point, 0) + 1
    return len([x for x in vents.values() if x > 1])


if __name__ == "__main__":
    print(solve(getInputs("05")))