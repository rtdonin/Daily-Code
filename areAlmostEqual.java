/**
 * taken from: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        boolean needsSwap = false;
        boolean swapMade = false;
        char expected = 0;
        char found = 0;

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if (!needsSwap) {
                    // if it's the first swap:
                    // store the values and flip the switch.
                    // if the switch if flipped on the last value, return false

                    if (i == s1.length() - 1) {
                        return false;
                    }

                    expected = s1.charAt(i);
                    found = s2.charAt(i);
                    needsSwap = true;
                    
                } else if (expected != s2.charAt(i) || found != s1.charAt(i)) {
                    // the switch has been flipped
                    // the values aren't the expected values

                    return false;
                } else if (swapMade){
                    return false;
                } else{
                    swapMade = true;
                }
            }
        }

        return swapMade == needsSwap;
    }

}