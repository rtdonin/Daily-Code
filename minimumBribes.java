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

/*
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
 * Each person wears a sticker indicating their initial position in the queue from 1 to n.
 * Any person can bribe the person directly in front of them to swap positions, but they
 * still wear their original sticker. One person can bribe at most two others. 
 * 
 * Determine the minimum number of bribes that took place to get to a given queue order.
 * Print the number of bribes, or, if anyone has bribed more than two people, print
 * Too chaotic.
 * 
 * Example
 * q = [1,2,3,5,4,6,7,8]
 * If person 5 bribes person 4, the queue will look like this: 1,2,3,4,5,6,7,8. Only 1
 * bribe is required. Print 1.
 * 
 * q = [4,1,2,3]
 * Person 4 had to bribe 3 people to get to the current position. Print Too chaotic.
 * 
 * Function Description
 * Complete the function minimumBribes in the editor below.
 * minimumBribes has the following parameter(s):
 * int q[n]: the positions of the people after all bribes
 * 
 * Returns
 * No value is returned. Print the minimum number of bribes necessary or Too chaotic if
 * someone has bribed more than 2 people.
*/

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
    
        int bribes = 0;
        
        int expectedFirst = 1;
        int expectedSecond = 2;
        int expectedThird = 3;
        
        for (int i = 0; i < q.size(); i++) {
            int sticker = q.get(i);

            if (sticker == expectedFirst) {
                expectedFirst = expectedSecond;
                expectedSecond = expectedThird;
                expectedThird++;
            } else if (sticker == expectedSecond) {
                bribes++;
                expectedSecond = expectedThird;
                expectedThird++;
            } else if (sticker == expectedThird) {
                bribes += 2;
                expectedThird++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
            
        }

        System.out.println(bribes);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
