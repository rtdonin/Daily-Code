/**
 * Taken from: https://leetcode.com/problems/shuffle-string/
 * 
 * Given a string s and an integer array indices of the same length.
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 * Return the shuffled string.
 * 
 */

class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] string = new char[indices.length];
        
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            string[index] = s.charAt(i);
         }
        
        return new String(string);
    }
}
