/*
 Taken From: https://leetcode.com/problems/valid-mountain-array/

 Given an array of integers arr, return true if and only if it is a valid mountain array.
 Recall that arr is a mountain array if and only if:

 arr.length >= 3
 There exists some i with 0 < i < arr.length - 1 such that:
 arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */

class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        // first remove an array based on definition of a mountain array.
        // find the peak
        // if the peak is not the real peak return false
        // -> as in if there is a repeat or numbers don't decrease properly.

        if (arr.length < 3) {
            return false;
        }

        boolean foundPeak = false;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                continue;
            }

            // test for repeat
            if (arr[i] == arr[i - 1]) {
                return false;
            }

            if (!foundPeak) {
                // before the peak is found,
                // if the current value is less than the previous we found our peak.
                if (arr[i] < arr[i - 1]) {

                    // but only if we aren't looking at the second element.
                    // our peak can not be the first value
                    if (i == 1) {
                        return false;
                    }

                    foundPeak = true;
                }

            } else {

                // after we have found the peak
                // if the current value is greater than the previous, return false
                if (arr[i] > arr[i - 1]) {
                    return false;
                }
            }
        }

        if (!foundPeak) {
            return false;
        }

        return true;
    }
}