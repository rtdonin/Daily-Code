/**
 * Taken from: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/submissions/826732423/
 */

class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 0) {
            low++;
        }
        if (high % 2 == 0) {
            high--;
        }

        return (high - low) / 2 + 1;
        
    }
}