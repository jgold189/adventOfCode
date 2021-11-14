package main

import (
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

func solve() {

}

func main() {

}
