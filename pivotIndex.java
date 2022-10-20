/**
 * Taken from: https://leetcode.com/problems/find-pivot-index/submissions/826727725/
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int pivot = -1;

        for (int i = 0; i < nums.length; i ++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];

            if (rightSum == leftSum) {
                pivot = i;
                break;
            } else {
                leftSum += nums[i];
            }
        }

        return pivot;
    }
}