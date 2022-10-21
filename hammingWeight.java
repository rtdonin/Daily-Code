/**
 * Taken from: https://leetcode.com/problems/number-of-1-bits/
 */

// The simple solution with the built in method

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

// The bitcounting solution

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;;

        while (n != 0) {
            ones += (n & 1);

            n = n>>>1;
        }

        return ones;
    }
}