package main

import (
	"testing"
)

func TestSolveInput1(t *testing.T) {
	input := "+1\n+1\n+1"
	answer := 3
	result := solve(input)
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}

func TestSolveInput2(t *testing.T) {
	input := "+1\n+1\n-2"
	answer := 0
	result := solve(input)
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}

func TestSolveInput3(t *testing.T) {
	input := "-1\n-2\n-3"
	answer := -6
	result := solve(input)
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}
