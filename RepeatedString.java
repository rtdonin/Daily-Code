
/**
 * Taken from: https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup&isFullScreen=true
 * 
 * There is a string, s, of lowercase English letters that is repeated
 * infinitely many times. Given an integer, n, find and print the number
 * of letter a's in the first n letters of the infinite string.
 * 
 * Example
 * s = "abcac"
 * n = 10
 * 
 * The substring we consider is abcacabcac, the first 10 characters of
 * the infinite string. There are 4 occurrences of a in the substring.
 * 
 * Function Description
 * Complete the repeatedString function in the editor below.
 * repeatedString has the following parameter(s):
 * s: a string to repeat
 * n: the number of characters to consider
 * 
 * Returns
 * int: the frequency of a in the substring
 * 
 * Constraints
 * 1 <= |s| <= 100
 * 1 <= n <= 10^12
 * For 25% of the test cases, n <= 10^6.
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

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        
        long divided = n / s.length();
        long modulo = n % s.length();
        long numOccurances = 0;
        long numOccurancesModulo = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                numOccurances++;
            }
            
            if (modulo - 1 == i) {
                numOccurancesModulo = numOccurances;
            }
        }
        
        System.out.println("divided " + divided + " * numOccurances " + numOccurances + " + modulo " + modulo + " * numOccurancesModulo " + numOccurancesModulo);
        
        if (numOccurances == 0) {
            return 0;
        }
        
        return divided * numOccurances + numOccurancesModulo;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
