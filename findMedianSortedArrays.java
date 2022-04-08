/**
 * taken from: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // merge
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m + n];
        
        int index1 = 0;
        int index2 = 0;
        
        for (int i = 0; i < m + n; i++) {
            if (index1 < m && index2 < n) {
                if (nums1[index1] < nums2[index2]) {
                    merge[i] = nums1[index1];
                    index1++;
                } else {
                    merge[i] = nums2[index2];
                    index2++;
                }
            } else if (index1 >= m) {
                // we finished with num1 and only need to add in num2 numbers
                merge[i] = nums2[index2];
                index2++;
            } else {
                // we finished with num2 and only need to add in num1 numbers
                merge[i] = nums1[index1];
                index1++;
            }
            
        }
        
        // median
        double median = 0;
        int halfLength = (m + n) / 2;
        
        if ((m + n) % 2 == 0) {
            // have to convert int to a double first
            median = merge[halfLength - 1] + merge[halfLength];
            median /= 2;
        } else {
            median = merge[halfLength];
        }
        
        return median;
    }
}