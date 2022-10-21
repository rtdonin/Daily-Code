/**
 * Take From: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * 
 */

class Solution {
    public double average(int[] salary) {
        int max = 0;;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int i = 0; i < salary.length; i++) {
            int current = salary[i];
            sum += current;

            if (max < current) {
                max = current;
            }

            if (min > current) {
                min = current;
            }
        }

        sum -= (max + min);

        double average = Double.valueOf(sum) / (salary.length - 2);

        return average;
    }
}