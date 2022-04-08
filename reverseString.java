/**
 * taken from: https://leetcode.com/problems/reverse-string/
 */

class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int halfLength = length / 2;
        
        for (int i = 0; i < halfLength; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }
}