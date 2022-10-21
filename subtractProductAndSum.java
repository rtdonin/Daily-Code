/**
 * Taken from: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 */

class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n != 0) {
            int temp = n % 10;
            product *= temp;
            sum += temp;

            n = (n - temp) / 10;
        }

        return product - sum;
        
    }
}