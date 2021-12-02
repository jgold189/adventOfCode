from aocUtil import *

def solve(inputs):
    results = 0
    for i in range(len(inputs)):
        if i != 0 and inputs[i] > inputs[i-1]:
            results += 1
    return results

if __name__ == "__main__":
    print(solve(getIntInputs("01")))