/*
 * https://leetcode.com/problems/two-sum/
 *
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // key = value needed value = index of the first value.
        // for example, for a at index i:
        // key = target - a; and  value = i
        Map<Integer, Integer> valueNeeded = new HashMap<>();
        int[] answer = new int[2];
        
        for (int i = 0; i < nums.length; i++){
            int current = nums[i];
            
            if(valueNeeded.containsKey(current)) {
                answer = new int[]{valueNeeded.get(current), i};
                
            } else {
                valueNeeded.put(target - current, i);
            }
        }
        
        return answer;
    }
}