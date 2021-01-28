/**
 * Taken from: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * 
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 */

class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        
        for (int i = 0; i < length; i++) {
            int greater = 0;
            
            for (int j = 0; j < length; j++){
                if(nums[i] > nums[j]) {
                    greater++;
                }
            }
            
            output[i] = greater;
        }
        
        return output;
    }
}