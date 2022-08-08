package main

import "fmt"

func main() {
	var feet float64
	fmt.Println("Enter a length in feet: ")
	fmt.Scanln(&feet)

	meters := Round(feet*0.3048, 0.05)

	fmt.Println("A lengh of ", feet, "ft is equal to ", meters, "m.")
}

func Round(x, unit float64) float64 {
	return float64(int64(x/unit+0.5)) * unit
}
