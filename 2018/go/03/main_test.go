package main

import (
	"testing"
)

func TestSolveInput1(t *testing.T) {
	input := [...]string{"#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"}
	result, err := solve(input[:])
	answer := 3
	if err != nil {
		t.Fatalf(`solve returned error. %s`, err)
	}
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}
