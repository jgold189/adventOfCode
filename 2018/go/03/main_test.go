package main

import (
	"testing"
)

func TestSolveInput1(t *testing.T) {
	input := [...]string{"#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"}
	result := solve(input[:])
	answer := 4
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}
