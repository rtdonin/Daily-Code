package main

/*
 * Write a program which prompts the user to first enter a name,
 * and then enter an address. Your program should create a map
 * and add the name and address to the map using the keys “name”
 * and “address”, respectively. Your program should use Marshal()
 * to create a JSON object from the map, and then your program
 * should print the JSON object.
 * Submit your source code for the program,
 * “makejson.go”.
 */

import (
	"encoding/json"
	"fmt"
)

type user struct {
	name, address string
}

func main() {
	var people map[string]string
	people = make(map[string]string)
	var name string
	var address string

	fmt.Print("\nEnter a name: ")
	fmt.Scanln(&name)

	fmt.Print("\nEnter an address: ")
	fmt.Scanln(&address)

	people[name] = address

	jsonPeople, err := json.Marshal(people)

	if err != nil {
		fmt.Print("\nERROR\n*********************\n\n")
	}

	var people1 map[string]string
	people1 = make(map[string]string)

	errNew := json.Unmarshal(jsonPeople, &people1)

	if errNew != nil {
		fmt.Print("\nERROR\n*********************\n\n")
	}

	fmt.Println("JSON Object: ", people1)

}
