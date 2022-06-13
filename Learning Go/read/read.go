package main

/*
 * Write a program which reads information from a file and represents
 * it in a slice of structs. Assume that there is a text file which
 * contains a series of names. Each line of the text file has a first
 * name and a last name, in that order, separated by a single space
 * on the line.
 *
 * Your program will define a name struct which has two fields, fname
 * for the first name, and lname for the last name. Each field will
 * be a string of size 20 (characters).
 *
 * Your program should prompt the user for the name of the text file.
 * Your program will successively read each line of the text file and
 * create a struct which contains the first and last names found in
 * the file. Each struct created will be added to a slice, and after
 * all lines have been read from the file, your program will have a
 * slice containing one struct for each line in the file. After
 * reading all lines from the file, your program should iterate
 * through your slice of structs and print the first and last names
 * found in each struct.
 **/

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strings"
)

type person struct {
	firstName string
	lastName  string
}

func main() {
	var path string

	fmt.Println("Please input full file path:")
	fmt.Scanln(&path)

	var names []person
	file, err := os.Open(path)

	if err != nil {
		panic(err)
	}

	defer file.Close()

	reader := bufio.NewReader(file)

	for {
		line, _, err := reader.ReadLine()

		if err != nil || io.EOF == err {
			break
		}
		name := strings.Split(string(line), " ")
		current := person{
			fixLongName(name[0]),
			fixLongName(name[1]),
		}
		names = append(names, current)
	}
	for i := 0; i < len(names); i++ {
		fmt.Println(i + 1)
		fmt.Println("First Name:" + names[i].firstName)
		fmt.Println("Last Name:" + names[i].lastName + "\n")
	}

	file.Close()
}

// Cut the string if the name is too long
func fixLongName(buffer string) string {

	if len(buffer) > 20 {
		return string(buffer[0:20])
	} else {
		return buffer
	}
}
