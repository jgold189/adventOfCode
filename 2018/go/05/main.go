package main

import (
	"fmt"
	"os"
	"strings"
)

func getStringInput() []byte {
	input, err := os.ReadFile("data.txt")
	if err != nil {
		panic(err)
	}
	return []byte(input)
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

func checkEqualButDiffCase(a, b byte) bool {
	if a != b && (a+32 == b || a-32 == b) {
		return true
	} else {
		return false
	}
}

// PART 2 NOTE: USE INTELLIGENT BRUTEFORCING. REMOVE THE LETTER THAT APPEARS THE MOST FIRST AND WORK FROM THERE.
func solve(input []byte) int {
	actionTaken := false
	result := make([]byte, 0, max(len(input)-25, len(input)))
	for i := 0; i < len(input); i++ {
		if i+1 != len(input) && checkEqualButDiffCase(input[i], input[i+1]) {
			// If the two are equal then do nothing and increment past it
			i++
			actionTaken = true
		} else {
			result = append(result, input[i])
		}
	}

	if actionTaken {
		return solve(result)
	} else {
		return len(input)
	}
}

func filterString(input []byte, lowerCaseByte byte) []byte {
	return []byte(strings.ReplaceAll(strings.ReplaceAll(string(input), string(lowerCaseByte), ""), string(lowerCaseByte-32), ""))
}

func solveHelper(input []byte) int {
	var lowestCount uint32 = ^uint32(0)
	for i := 97; i <= 122; i++ {
		count := solve(filterString(input, byte(i)))
		if count < int(lowestCount) {
			lowestCount = uint32(count)
		}
	}
	return int(lowestCount)
}

func main() {
	fmt.Println(solveHelper(getStringInput()))
}
