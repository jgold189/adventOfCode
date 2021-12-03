from aocUtil import *
from collections import Counter
from copy import deepcopy

# This is some really bad code because I was trying to do this as fast as possible
def solve(inputs):
    # Some great code from stackOverflow to rotate a list
    oxy = ""
    oxyOptions = deepcopy(inputs)
    for i in range(len(inputs[0])):

        if len(oxyOptions) == 1:
            break

        rotatedList = list(zip(*oxyOptions[::-1]))
        count = Counter(rotatedList[i])
        if len(count) == 2:
            most, least = count.most_common(2)
            if most[1] != least[1]:
                oxyOptions = list(filter(lambda x: x[i] == most[0], oxyOptions))
            else:
                oxyOptions = list(filter(lambda x: x[i] == "1", oxyOptions))
    oxy = oxyOptions[0]


    co = ""
    coOptions = deepcopy(inputs)
    for i in range(len(inputs[0])):

        if len(coOptions) == 1:
            break

        rotatedList = list(zip(*coOptions[::-1]))
        count = Counter(rotatedList[i])
        if len(count) == 2:
            most, least = count.most_common(2)
            if most[1] != least[1]:
                coOptions = list(filter(lambda x: x[i] == least[0], coOptions))
            else:
                coOptions = list(filter(lambda x: x[i] == "0", coOptions))
    co = coOptions[0]
            
    return int(oxy, 2) * int(co, 2)


if __name__ == "__main__":
    print(solve(getInputs("03")))