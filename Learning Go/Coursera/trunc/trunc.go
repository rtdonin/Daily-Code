package main

import (
	"fmt"
)

func main() {
	var number int

	fmt.Print("Enter a decimal number:")
	fmt.Scanln(&number)
	fmt.Print("Converted float to int: ", number)
}
