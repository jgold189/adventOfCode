package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func getStringInput() []string {
	input, err := os.ReadFile("data.txt")
	if err != nil {
		panic(err)
	}
	return strings.Split(string(input), "\n")
}

func atoiWithPanic(s string) int {
	i, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	} else {
		return i
	}
}

func splitInput(input string) (int, int, int, int, int) {
	// #123 @ 3,2: 5x4
	fields := strings.Fields(input)
	offsetSlice := strings.Split(fields[2], ",")
	sizeSlice := strings.Split(fields[3], "x")
	return atoiWithPanic(fields[0][1:]), atoiWithPanic(offsetSlice[0]), atoiWithPanic(offsetSlice[1][:len(offsetSlice[1])-1]), atoiWithPanic(sizeSlice[0]), atoiWithPanic(sizeSlice[1])
}

func solve(input []string) int {
	data := [1200][1200]int{}
	for _, v := range input {
		// claimId, xOffset, yOffset, width, height
		_, xOffset, yOffset, width, height := splitInput(v)
		for i := xOffset; i < xOffset+width; i++ {
			for j := yOffset; j < yOffset+height; j++ {
				data[i][j]++
			}
		}
	}
	count := 0
	for i := 0; i < len(data); i++ {
		for j := 0; j < len(data[0]); j++ {
			if data[i][j] > 1 {
				count++
			}
		}
	}
	return count
}

func main() {
	fmt.Println(solve(getStringInput()))
}
