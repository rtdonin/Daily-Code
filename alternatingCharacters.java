/*
 * From: https://www.hackerrank.com/challenges/alternating-characters/problem
 * 
 * You are given a string containing characters A and B only. Your task is
 * to change it into a string such that there are no matching adjacent
 * characters. To do this, you are allowed to delete zero or more
 * characters in the string. Your task is to find the minimum number of
 * required deletions.
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
    // Write your code here
        int delete = 0;
        char previous = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            
            char current = s.charAt(i);
            
            if (current == previous) {
                delete++;
            }
            
            previous = current;
        }
        
        return delete;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
