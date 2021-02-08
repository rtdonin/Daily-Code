/**
 * taken from:
 * https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 * 
 * There is a large pile of socks that must be paired by color. Given an array
 * of integers representing the color of each sock, determine how many pairs of
 * socks with matching colors there are.
 * 
 * Function Description: sockMerchant has the following parameter(s): int n: the
 * number of socks in the pile int ar[n]: the colors of each sock
 * 
 * Returns: int: the number of pairs
 * 
 */

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            if (ar[0] == ar[1]) {
                return 1;
            } else {
                return 0;
            }
        }

        Map<Integer, Integer> organized = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.println(i + "= i. " + organized.containsKey(ar[i]));

            if (organized.containsKey(ar[i])) {

                organized.replace(ar[i], organized.get(ar[i]) + 1);

            } else {
                organized.put(ar[i], 1);
            }

        }

        Set<Integer> values = organized.keySet();

        int numOfPairs = 0;

        for (Integer i : values) {
            int socks = organized.get(i);
            numOfPairs += socks / 2;
        }

        return numOfPairs;

    }
}