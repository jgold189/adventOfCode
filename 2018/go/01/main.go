package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func getStringInput() string {
	input, err := os.ReadFile("data.txt")
	if err != nil {
		panic(err)
	}
	return string(input)
}

func solve(input string) int {
	splitInput := strings.Split(input, "\n")

	resultsMap := make(map[int]int)
	runningCount := 0
	for {
		for i := range splitInput {
			num, err := strconv.Atoi(splitInput[i])
			if err != nil {
				panic(err)
			}
			runningCount += int(num)

			num, ok := resultsMap[runningCount]
			if ok {
				return runningCount
			} else {
				resultsMap[runningCount] = 1
			}
		}
	}
}

func main() {
	fmt.Println(solve(getStringInput()))
}
