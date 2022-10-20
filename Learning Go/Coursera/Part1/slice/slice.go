package main

import (
	"fmt"
	"sort"
	"strconv"
)

func main() {

	sli := make([]int, 0, 3)

	for true {
		var inputString string
		fmt.Print("Enter an integer:")
		fmt.Scanln(&inputString)

		if inputString == "X" || inputString == "x" {
			// if user input X, abort.
			fmt.Print("Goodbye")
			break
		}

		// convert string to int
		inputInt, err := strconv.Atoi(inputString)

		if err != nil {
			fmt.Println("Whoops try that again.")
			continue
		}

		sli = append(sli, inputInt)
		sort.Ints(sli)

		fmt.Println(sli)

	}

}
