package main

import (
	"fmt"
	"math"
)

func main() {
	var fTemp float64

	fmt.Println("Enter a temprature in Fahrenheit: ")
	fmt.Scanln(&fTemp)

	cTemp := math.Round((fTemp - 32) * 5 / 9)

	fmt.Println(fTemp, "F is the equal to ", cTemp, "C")
}
