package main

import (
	"testing"
)

func TestSolveInput1(t *testing.T) {
	input := [...]string{"abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"}
	result := solve(input[:])
	answer := 12
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}
