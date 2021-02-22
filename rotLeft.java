
/**
 * Taken From: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * A left rotation operation on an array shifts each of the array's elements 1 unit to
 * the left. For example, if 1 left rotations are performed on array [1,2,3,4,5], then
 * the array would become [3,4,5,1,2]. Note that the lowest index item moves to the
 * highest index in a rotation. This is called a circular array.
 * 
 * Given an array a of n integers and a number, d, perform d left rotations on the
 * array. Return the updated array to be printed as a single line of space-separated
 * integers.
 * 
 * Function Description
 * Complete the function rotLeft in the editor below.
 * rotLeft has the following parameter(s):
 * int a[n]: the array to rotate
 * int d: the number of rotations
 * 
 * Returns
 * int a'[n]: the rotated array
 * 
 * Constraints
 * 1 <= n <= 1-^5
 * 1 <= d <= n
 * 1 <= a[i] <= 10^6
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

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] b = new int[a.length]; // shifted array
        
        int restart = a.length - d;
        
        for (int i = 0; i + d < a.length; i++) {
            b[i] = a[i + d];
        }

        for (int i = 0; i + restart < a.length; i++) {
            b[i + restart] = a[i];
        }
        return b;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
