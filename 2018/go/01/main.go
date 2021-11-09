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

	result := 0
	for i := range splitInput {
		num, err := strconv.Atoi(splitInput[i])
		if err != nil {
			panic(err)
		}
		result += int(num)
	}
	return result
}

func main() {
	fmt.Println(solve(getStringInput()))
}
