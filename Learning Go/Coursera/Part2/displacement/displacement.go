package main

import (
	"fmt"
	"math"
)

/**
 * Let us assume the following formula for displacement s as a
 * function of time t, acceleration a, initial velocity vo,and
 * initial displacement so.
 *
 * s = ½ a t2 + vot + so
 *
 * Write a program which first prompts the user to enter
 * values for acceleration, initial velocity, and initial
 * displacement. Then the program should prompt the user to
 * enter a value for time and the program should compute the
 * displacement after the entered time.
 *
 * You will need to define and use a function called
 * GenDisplaceFn() which takes three float64 arguments,
 * acceleration a, initial velocity vo, and initial
 * displacement so. GenDisplaceFn() should return a function
 * which computes displacement as a function of time, assuming
 * the given values acceleration, initial velocity, and initial
 * displacement. The function returned by GenDisplaceFn()
 * should take one float64 argument t, representing time, and
 * return one float64 argument which is the displacement
 * travelled after time t.
 *
 * For example, let’s say that I want to assume the following
 * values for acceleration, initial velocity, and initial
 * displacement: a = 10, vo = 2, so = 1. I can use the
 * following statement to call GenDisplaceFn() to generate a
 * function fn which will compute displacement as a function
 * of time.
 *
 * fn := GenDisplaceFn(10, 2, 1)
 *
 * Then I can use the following statement to print the
 * displacement after 3 seconds.
 *
 * fmt.Println(fn(3))
 *
 * And I can use the following statement to print the
 * displacement after 5 seconds.
 *
 * fmt.Println(fn(5))
 *
 */

func main() {

	var a float64  // acceleration
	var vo float64 // initial velocity
	var so float64 // initial displacement
	var t float64  // final time

	// get values
	fmt.Print("Please type in acceleration: ")
	fmt.Scanln(&a)

	fmt.Print("Please type in the initial velocity: ")
	fmt.Scanln(&vo)

	fmt.Print("Please type in initial displacement: ")
	fmt.Scanln(&so)

	fmt.Print("To receive final displacement, please type in final time to recieve final displacement: ")
	fmt.Scanln(&t)

	// compute final displacement.
	fn := GenDisplaceFn(a, vo, so)

	// print final displacement
	fmt.Println("Final displacement:", fn(t))
}

func GenDisplaceFn(a, vo, so float64) func(float64) float64 {
	fn := func(t float64) float64 {
		return (0.5)*a*math.Pow(t, 2) + vo*t + so
	}

	return fn(t)
}
