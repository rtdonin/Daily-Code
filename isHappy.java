/**
 * taken from: https://leetcode.com/problems/happy-number/
 */

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> previous = new HashSet<>();

        int sum;
        int digits;
        int digit = 0;

        while(n != 1) {
            sum = 0;
            digits = 0;

            while (n > 0) {
                digit = n % 10;
                digits = digits * 10 + digit;
                sum += Math.pow((double) digit, 2.0);
                n = (n - (digit))/ 10;

            }

            n = sum;

            if (previous.contains(digits)) {
                return false;
            } else {
                previous.add(digits);
            }

        }

        return true;
    }
}