
/**
 * Taken from: https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting&isFullScreen=true
 * 
 * Mark and Jane are very happy after having their first child.
 * Their son loves toys, so Mark wants to buy some. There are a
 * number of different toys lying in front of him, tagged with
 * their prices. Mark has only a certain amount to spend, and
 * he wants to maximize the number of toys he buys with this
 * money. Given a list of toy prices and an amount to spend,
 * determine the maximum number of gifts he can buy.
 * 
 * Note: Each toy can be purchased only once.
 * 
 * Example
 * prices = [1,2,3,4]
 * k = 7
 * The budget is 7 units of currency. He can buy items that
 * cost [1,2,3] for 6, or [3,4] for 7 units.
 * The maximum is 3 items.
 * 
 * Function Description
 * Complete the function maximumToys in the editor below.
 * maximumToys has the following parameter(s):
 * int prices[n]: the toy prices
 * int k: Mark's budget
 * 
 * Returns
 * int: the maximum number of toys
 * 
 * Constraints
 * 1 <= n <= 10^5
 * 1 <= k <= 10^9
 * 1 <= prices[i] <= 10^9
 * A toy can't be bought multiple times.
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

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        // Sort prices greatest to least
        
        int budget = 0;
        int max = 0;
        int n = prices.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (prices[j] < prices [j + 1]) {
                    int m = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = m;
                }
            }
            
            budget += prices[n - i - 1];
            
            if (budget <= k) {
                max++;
            } else {
                break;
            }
        }
        

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
