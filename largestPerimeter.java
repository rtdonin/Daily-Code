/**
 * taken from: https://leetcode.com/problems/largest-perimeter-triangle/
 *
 */

 class Solution {
    public int largestPerimeter(int[] nums) {

        int shift = 0;

        for (int i = 0; i < nums.length; i++) {
            
            boolean swaps = false;

            for (int j = nums.length - 1; j - 1 >= 0; j--){
                if (nums[j] > nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swaps = true;
                }
            }

            if (i >= 2) {
                if(checkTriangle(nums[0 + shift], nums[1 + shift], nums[2 + shift])) {
                    return nums[0 + shift] + nums[1 + shift] + nums[2 + shift];
                } else {
                    shift++;
                }
            }

            if (!swaps) {
                break;
            }

        }

        System.out.println(Arrays.toString(nums));

        while (shift + 2 < nums.length) {
            System.out.println(shift);

            if(checkTriangle(nums[0 + shift], nums[1 + shift], nums[2 + shift])) {
                return nums[0 + shift] + nums[1 + shift] + nums[2 + shift];
            } else {
                shift++;
            }
        
        }

        return 0;
    }

    boolean checkTriangle (int side1, int side2, int side3) {
        System.out.println("inside checktriangle: " + side1 + " " + side2 + " " + side3 );
        return side1 < (side2 + side3);
    }
}