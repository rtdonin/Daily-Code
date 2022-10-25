/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 * 
 */

class Solution {
    public int arraySign(int[] nums) {
        int neg = 0; // count the number of negatives

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                neg++;
            }
        }

        if (neg % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}