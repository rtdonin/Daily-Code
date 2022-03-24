/**
 * taken from: https://leetcode.com/problems/merge-sorted-array/
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // PLAN:
        // place greater value at the end each time.
        
        if (n == 0) {
            return;
        }
        
        int i = m - 1; // index nums1 m + n
        int j = n - 1; // index nums2 n
        int k = m + n - 1; // index for num1 to interate backwards
        
        while (k >= 0 && j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            
            k--;
        }        
    }
}