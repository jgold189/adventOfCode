package main

import (
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
	"time"
)

// action Mappings: 1 - startShift, 2 - fall asleep, 3 - wake up
type shiftLine struct {
	datetime time.Time
	min      int
	guardId  int
	action   int
}

func getStringInput() []string {
	input, err := os.ReadFile("data.txt")
	if err != nil {
		panic(err)
	}
	return strings.Split(string(input), "\n")
}

func sumSlice(input []int) int {
	result := 0
	for _, v := range input {
		result += v
	}
	return result
}

/* Example Inputs
[1518-10-16 00:04] Guard #479 begins shift
[1518-07-18 00:55] falls asleep
[1518-05-03 00:57] wakes up
*/
// Gets a shiftLine from a string
func getShiftLineString(input string) shiftLine {
	shift := shiftLine{}

	// Get the datetime from the input string
	datetime, err := time.Parse("2006-01-02 15:04", input[1:17])
	if err != nil {
		panic(err)
	} else {
		shift.datetime = datetime
		shift.min = datetime.Minute()
	}

	// Set the action
	if strings.Contains(input, "falls asleep") {
		shift.action = 2
	} else if strings.Contains(input, "wakes up") {
		shift.action = 3
	} else {
		shift.action = 1
		// Get and set guard id from the string
		idIndex := strings.Index(input, "#")
		guardIdString := strings.SplitN(input[idIndex:], " ", 2)[0][1:]
		guardId, err := strconv.Atoi(guardIdString)
		if err != nil {
			panic(err)
		} else {
			shift.guardId = guardId
		}
	}
	return shift
}

func solve(input []string) int {
	shiftSlice := make([]shiftLine, len(input))
	// Convert every string to a shift struct
	for i, v := range input {
		shiftSlice[i] = getShiftLineString(v)
	}

	// And sort them based on their datetime to put them in order, ascending order
	sort.Slice(shiftSlice, func(i, j int) bool {
		return shiftSlice[i].datetime.Before(shiftSlice[j].datetime)
	})

	// Get the count of every minute for every guard and how much they are asleep
	guardMinSleepCount := make(map[int][]int)
	currentGuardId := 0
	sleepStartMin := -1
	for _, v := range shiftSlice {
		if v.guardId != 0 {
			// Do something to finish up the last segment
			if sleepStartMin != -1 {
				for i := sleepStartMin; i < 60; i++ {
					guardMinSleepCount[currentGuardId][i]++
				}
			}
			currentGuardId = v.guardId

			// Check to make sure we have an initialized slice for this guard and if not then make it
			_, ok := guardMinSleepCount[currentGuardId]
			if !ok {
				guardMinSleepCount[currentGuardId] = make([]int, 60)
			}
		} else if v.action == 2 {
			sleepStartMin = v.min
		} else if v.action == 3 {
			for i := sleepStartMin; i < v.min; i++ {
				guardMinSleepCount[currentGuardId][i]++
			}
			sleepStartMin = -1
		}
	}

	var mostTiredGuard int
	var mostSleptMin int
	mostSleptAmount := -1
	for guardId := range guardMinSleepCount {
		for min, v := range guardMinSleepCount[guardId] {
			if v > mostSleptAmount {
				mostSleptAmount = v
				mostSleptMin = min
				mostTiredGuard = guardId
			}
		}
	}

	return mostSleptMin * mostTiredGuard
}

func main() {
	fmt.Println(solve(getStringInput()))
}
