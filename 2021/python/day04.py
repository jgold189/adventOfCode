from aocUtil import *

class BingoBoard:
    def __init__(self, board):
        self.board = board
        self.marked = {}

    def __str__(self):
        return "Board:\n"  + str(self.board) + "\nMarked:\n" + str(self.marked)

    def markNumber(self, num):
        self.marked[num] = 1
        return self.checkWin()

    def checkWin(self):
        for row in self.board:
            if len([x for x in row if self.marked.get(x, 0)]) == 5:
                return True
        for i in range(len(self.board[0])):
            if len([x[i] for x in self.board if self.marked.get(x[i], 0)]) == 5:
                return True
        return False

    def getScore(self, winningNum):
        unnmarkedNums = []
        for row in self.board:
            unnmarkedNums.extend([x for x in row if self.marked.get(x, 0) == 0])
        return sum([int(x) for x in unnmarkedNums]) * int(winningNum)


# First item is drawing order, second item is a list of BingoBoard objects
def getBingoInputs(rawData):
    drawOrder = rawData[0].split(",")
    boards = []
    currentBoard = []
    for line in rawData[2:]:
        if line == "":
            boards.append(BingoBoard(currentBoard))
            currentBoard = []
        else:
            currentBoard.append([x for x in line.split(" ") if x != ""])
    boards.append(BingoBoard(currentBoard))
    return (drawOrder, boards)

def solve(inputs):
    drawOrder, boards = getBingoInputs(inputs)
    for num in drawOrder:
        for board in boards:
            if board.markNumber(num):
                return board.getScore(num)
    raise Exception("No winning board found")


if __name__ == "__main__":
    print(solve(getInputs("04")))