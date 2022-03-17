/**
 * taken from : https://leetcode.com/problems/maximum-subarray/
 * 
 * Given an integer array nums, find the contiguous subarray (containing
 * at least one number) which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 */

class Solution {
    public int maxSubArray(int[] nums) {
        
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            currentSum = currentSum + num > num ? currentSum + num : num;
            bestSum = currentSum > bestSum ? currentSum: bestSum;
            
        }
        
        return bestSum;

    }
}