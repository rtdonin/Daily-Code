
/**
 * Taken from: https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * 
 * Consider the following version of Bubble Sort:
 * for (int i = 0; i < n; i++) {
 *  for (int j = 0; j < n - 1; j++) {
 *      // Swap adjacent elements if they are in decreasing order
 *      if (a[j] > a[j + 1]) {
 *          swap(a[j], a[j + 1]);
 *      }
 *  }
 * }
 * 
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above.
 * Once sorted, print the following three lines:
 * Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
 * First Element: firstElement, where  is the first element in the sorted array.
 * Last Element: lastElement, where  is the last element in the sorted array.
 * 
 * Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur during execution.
 * 
 * Example
 * swap    a       
 * 0       [6,4,1]
 * 1       [4,6,1]
 * 2       [4,1,6]
 * 3       [1,4,6]
 * The steps of the bubble sort are shown above. It took 3 swaps to sort the array.
 * Output is:
 * Array is sorted in 3 swaps.
 * First Element: 1
 * Last Element: 6
 * 
 * Function Description
 * Complete the function countSwaps in the editor below.
 * countSwaps has the following parameter(s):
 * int a[n]: an array of integers to sort
 * 
 * Prints
 * Print the three lines required, then return. No return value is expected.
 * 
 * Constraints
 * 2 <= n <= 600
 * 1 <= a[i] = 2 x 10^6
 * 
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int swaps = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            boolean madeSwaps = false;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int p = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = p;

                    swaps++;
                    madeSwaps = true;
                }
            }

            if (!madeSwaps) {
                break;
            }
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
