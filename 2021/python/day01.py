from aocUtil import *

def generateSlidingWindowList(inputs, window):
    results = []
    for i in range(0, len(inputs) - window + 1):
        results.append(sum(inputs[i:i + window]))
    return results

def solve(inputs):
    windowed = generateSlidingWindowList(inputs, 3)
    results = 0
    for i in range(1, len(windowed)):
        if windowed[i] > windowed[i-1]:
            results += 1
    return results

if __name__ == "__main__":
    print(solve(getIntInputs("01")))
