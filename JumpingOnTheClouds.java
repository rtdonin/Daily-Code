
/**
 * Taken from: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup&isFullScreen=true
 * 
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is equal
 * to the number of the current cloud plus 1 or 2. The player must avoid the thunderheads.
 * 
 * Determine the minimum number of jumps it will take to jump from the starting postion
 * to the last cloud. It is always possible to win the game. For each game, you will get
 * an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 * 
 * Example
 * c = [0,1,0,0,0,1,0]
 * Index the array from 0...6. The number on each cloud is its index in the list so the
 * player must avoid the clouds at indices 1 and 5. They could follow these two paths:
 * 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6.
 * The first path takes 3 jumps while the second takes 4.
 * Return 3.
 * 
 * Function Description
 * Complete the jumpingOnClouds function in the editor below.
 * jumpingOnClouds has the following parameter(s):
 * int c[n]: an array of binary integers
 * 
 * Returns
 * int: the minimum number of jumps required
 * 
 * Constraints
 * 2 <= n <= 100
 * c[i] is in set {0,1}
 * c[0] = c[n-1] = 0
 * 
 * Output Format
 * Print the minimum number of jumps needed to win the game.
 * 
 * My Solution:
 * We know the minimum number of jumps (minJumps) for any size int[] arr.
 * minJumps = arr.length / 2 and floored.
 * We want to discover if there are conditions for which the minJumps increases.
 * After writing out some differnt arrays I noticed two things:
 * 1) all even sized arrays have a small jump and no odd arrays have a small jump.
 * 2) even numbers of consecutive zeros (consecutiveZeros) create the conditions we are interested in.
 * 
 * After thinking I figured it out I was still missing something.
 * 
 * All sets get affected on every other set of even consecutiveZeros
 * An even sized array only gets affected on the second set.
 * An odd sized array only gets affected on the first set. * 
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int clouds = c.length;

        if (clouds == 2 || clouds == 3) {
            return 1;
        } else if (clouds == 4) {
            return 2;
        }

        int minJumps = (int) Math.floor(clouds / 2);
        int consecutiveZeros = 0;
        boolean addJump = clouds % 2 != 0;

        System.out.println(minJumps);

        for (int i = 0; i < clouds; i++) {
            if (c[i] == 0) {
                consecutiveZeros++;

            } else {
                if (consecutiveZeros % 2 == 0) {
                    if (addJump) {
                        minJumps++;
                    }

                    addJump = !addJump;
                }

                consecutiveZeros = 0;
            }
        }

        return minJumps;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
