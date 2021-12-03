from aocUtil import *
from collections import Counter

def solve(inputs):
    gamma, epsilon = "", ""
    # Some great code from stackOverflow to rotate a list
    rotatedList = list(zip(*inputs[::-1]))
    for row in rotatedList:
        count = Counter(row)
        gamma += count.most_common(1)[0][0]
        epsilon += count.most_common(2)[1][0]
    return int(gamma, 2) * int(epsilon, 2)


if __name__ == "__main__":
    print(solve(getInputs("03")))