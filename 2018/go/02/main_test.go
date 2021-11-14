package main

import (
	"testing"
)

func TestSolveInput1(t *testing.T) {
	input := [...]string{"abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"}
	result, err := solve(input[:])
	answer := "fgij"
	if err != nil {
		t.Fatalf(`solve returned an error: %s`, err)
	}
	if result != answer {
		t.Fatalf(`solve is wrong. Wanted %s, got %s`, answer, result)
	}
}
