package main

import (
	"fmt"
	"os"
	"strings"
)

func getStringInput() []string {
	input, err := os.ReadFile("data.txt")
	if err != nil {
		panic(err)
	}
	return strings.Split(string(input), "\n")
}

func getCharCountMap(input string) map[byte]int {
	results := make(map[byte]int)
	chars := []byte(input)
	for _, v := range chars {
		value, ok := results[v]
		if ok {
			results[v] = value + 1
		} else {
			results[v] = 1
		}
	}
	return results
}

func solve(input []string) int {
	twoCount, threeCount := 0, 0
	for i := range input {
		isTwo, isThree := false, false
		charCountMap := getCharCountMap(input[i])
		for _, count := range charCountMap {
			if count == 2 && !isTwo {
				twoCount++
				isTwo = !isTwo
			}
			if count == 3 && !isThree {
				threeCount++
				isThree = !isThree
			}
		}
	}
	return twoCount * threeCount
}

func main() {
	fmt.Println(solve(getStringInput()))
}
