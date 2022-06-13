package main

import (
	"fmt"
	"strings"
)

/*
 * Write a program which prompts the user to enter a string.
 * The program searches through the entered string for the characters ‘i’, ‘a’, and ‘n’.
 * The program should print “Found!” if the entered string starts with the character ‘i’,
 * ends with the character ‘n’, and contains the character ‘a’. The program should print “Not Found!” otherwise.
 * The program should not be case-sensitive, so it does not matter if the characters are upper-case or lower-case.
 *
 * Examples: The program should print “Found!” for the following example entered strings, “ian”, “Ian”, “iuiygaygn”,
 * “I d skd a efju N”. The program should print “Not Found!” for the following strings, “ihhhhhn”, “ina”, “xian”.
 */
func main() {
	var input string
	message := "Not Found"
	foundA := false

	fmt.Print("Enter a string:")
	fmt.Scanln(&input)

	input = strings.ToUpper(input)

	foundI := strings.HasPrefix(input, "I")
	foundN := strings.HasSuffix(input, "N")

	if strings.IndexAny(input, "A") > 1 {
		foundA = true
	}

	if foundI && foundA && foundN {
		message = "Found"
	}

	fmt.Print(message)
}
