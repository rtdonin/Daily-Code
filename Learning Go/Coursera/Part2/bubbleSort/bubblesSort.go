package main

import (
	"fmt"
	"strconv"
	"strings"
)

/**
 * TASK:
 *
 * Write a Bubble Sort program in Go. The program should prompt
 * the user to type in a sequence of up to 10 integers. The program
 * should print the integers out on one line, in sorted order, from
 * least to greatest. Use your favorite search tool to find a
 * description of how the bubble sort algorithm works.

 * As part of this program, you should write function called
 * BubbleSort() which takes a slice of integers as an argument and
 * returns nothing. The BubbleSort() function should modify the
 * slice so that the elements are in sorted order.
 *
 * A recurring operation in the bubble sort algorithm is the Swap
 * operation which swaps the position of two adjacent elements in
 * the slice. You should write a Swap() function which performs
 * this operation. Your Swap() function should take two arguments,
 * a slice of integers and an index value i which indicates a
 * position in the slice. The Swap() function should return
 * nothing, but it should swap the contents of the slice in
 * position i with the contents in position i+1.
 */

func main() {
	fmt.Println("Hello!")

	var slice = make([]int, 0, 10)

	for i := 0; i < 10; i++ {

		var number string

		fmt.Println("Enter a number or type \"stop\" to stop entering numbers.")
		fmt.Scanln(&number)

		if strings.ToLower(number) == "stop" {
			break
		}

		num, oops := strconv.Atoi(number)

		if oops != nil {
			fmt.Println("That was an invalid entry.")
		}

		slice = append(slice, num)
	}

	BubbleSort(slice)

	sliceString := "["

	for i, e := range slice {

		sliceString += strconv.FormatInt(int64(e), 10)

		if i < len(slice)-1 {
			sliceString += ", "
		} else {
			sliceString += "]"
		}
	}

	fmt.Println("Your numbers sorted:", sliceString)

}

/**
 * param: slice of ints
 * sorts slice
 * returns: void.
 */

func BubbleSort(arr []int) {

	for i := range arr {
		swapsMade := false
		for j := 0; j < len(arr)-1-i; j++ {
			if arr[j] > arr[j+1] {
				Swap(arr, j)
				swapsMade = true
			}
		}

		if swapsMade == false {
			break
		}
	}
}

/**
 * param: slice of ints, index i int
 * swaps the element at position i with the element in position i+1.
 * returns void
 */

func Swap(arr []int, i int) {
	temp := arr[i+1]
	arr[i+1] = arr[i]
	arr[i] = temp
}
