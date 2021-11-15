package main

import (
	"errors"
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

// claimId, xOffset, yOffset, width, height
func splitInput(input string) (int, int, int, int, int) {
	// #123 @ 3,2: 5x4
	fields := strings.Fields(input)
	offsetSlice := strings.Split(fields[2], ",")
	sizeSlice := strings.Split(fields[3], "x")
	return atoiWithPanic(fields[0][1:]), atoiWithPanic(offsetSlice[0]), atoiWithPanic(offsetSlice[1][:len(offsetSlice[1])-1]), atoiWithPanic(sizeSlice[0]), atoiWithPanic(sizeSlice[1])
}

func solve(input []string) (int, error) {
	data := [1200][1200]int{}
	uniqueMap := make(map[int]bool)
	for _, v := range input {
		// claimId, xOffset, yOffset, width, height
		claimId, xOffset, yOffset, width, height := splitInput(v)
		for i := xOffset; i < xOffset+width; i++ {
			for j := yOffset; j < yOffset+height; j++ {
				if data[i][j] != 0 {
					uniqueMap[claimId] = false
					uniqueMap[data[i][j]] = false
				} else {
					data[i][j] = claimId
					_, ok := uniqueMap[claimId]
					if !ok {
						uniqueMap[claimId] = true
					}
				}

			}
		}
	}
	for claimId, v := range uniqueMap {
		if v {
			return claimId, nil
		}
	}
	return 0, errors.New("No unique claimId found")
}

func main() {
	result, err := solve(getStringInput())
	if err != nil {
		panic(err)
	} else {
		fmt.Println(result)
	}

}
