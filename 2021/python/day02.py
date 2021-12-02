from aocUtil import *

def solve(inputs):
    x, y, aim = 0, 0, 0
    for line in inputs:
        command, amount = line.split(" ")
        if command == "forward":
            x += int(amount)
            y += aim * int(amount)
        elif command == "down":
            aim += int(amount)
        elif command == "up":
            aim -= int(amount)
        else:
            raise ValueError("The value for command was not expected")
    return x * y

if __name__ == "__main__":
    print(solve(getInputs("02")))