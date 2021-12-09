from aocUtil import *

def solve(inputs):
    digits = {0: 6, 1: 2, 2: 5, 3: 5, 4: 4, 5: 5, 6: 6, 7: 3, 8: 7, 9: 6}
    uniqNums = set([digits[x] for x in [1, 4, 7, 8]])
    result = 0
    for line in inputs:
        patterns, output = [x.split(" ") for x in line.split(" | ")]
        result += len([1 for x in output if len(x) in uniqNums])
    return result


if __name__ == "__main__":
    print(solve(getInputs("08")))