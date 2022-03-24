/**
 * take from: https://leetcode.com/problems/first-bad-version/
 */

/*
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version);
 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        // just in case -> minimize calculations
        if (n == 1) {
            return 1;
        }

        // binary search values
        int lower = 1;
        int upper = n;

        while (lower < upper) {
            int mid = (upper - lower) / 2 + lower;

            if (isBadVersion(mid)) {

                upper = mid;
            } else {

                lower = mid + 1;
            }
        }

        return upper;
    }
}