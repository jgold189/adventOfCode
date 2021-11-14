package main

import (
	"errors"
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

func solve(input []string) (string, error) {
	for i := range input[0] {
		letterMap := make(map[string]int)
		for j, value := range input {
			tempString := value[0:i] + value[i+1:]
			_, ok := letterMap[tempString]
			if ok {
				return tempString, nil
			} else {
				letterMap[tempString] = j
			}
		}
	}
	return "", errors.New("No result found")
}

func main() {
	result, err := solve(getStringInput())
	if err != nil {
		fmt.Println(err)
		panic(1)
	} else {
		fmt.Println(result)
	}
}
