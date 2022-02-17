/*
 * taken from: https://leetcode.com/problems/contains-duplicate/description/
 */


class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            int setSize = set.size();
            set.add(nums[i]);
            
            int newSize = set.size();
            
            if (newSize == setSize) {
              return true;
            }
            
        }
        
        return false;
    }
}