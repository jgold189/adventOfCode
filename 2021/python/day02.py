from aocUtil import *

def solve(inputs):
    x, y = 0, 0
    for line in inputs:
        command, amount = line.split(" ")
        if command == "forward":
            x += int(amount)
        elif command == "down":
            y += int(amount)
        elif command == "up":
            y -= int(amount)
        else:
            raise ValueError("The value for command was not expected")
    return x * y

if __name__ == "__main__":
    print(solve(getInputs("02")))