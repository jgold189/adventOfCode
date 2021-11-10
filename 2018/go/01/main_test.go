package main

import (
	"testing"
)

func TestSolveInput1(t *testing.T) {
	input := "+1\n-1"
	answer := 1
	result := solve(input)
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}

func TestSolveInput2(t *testing.T) {
	input := "+3\n+3\n+4\n-2\n-4"
	answer := 10
	result := solve(input)
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}

func TestSolveInput3(t *testing.T) {
	input := "-6\n+3\n+8\n+5\n-6"
	answer := 5
	result := solve(input)
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}

func TestSolveInput4(t *testing.T) {
	input := "+7\n+7\n-2\n-7\n-4"
	answer := 14
	result := solve(input)
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %d, got %d`, answer, result)
	}
}
