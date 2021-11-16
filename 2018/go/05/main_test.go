package main

import (
	"testing"
)

func TestSolveInput1(t *testing.T) {
	input := []byte("dabAcCaCBAcCcaDA")
	result := solve(input)
	answer := 10
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}
