/*
 * Taken from leetcode: https://leetcode.com/problems/roman-to-integer/
 * 
 */


class Solution {
    public int romanToInt(String s) {
        int value = 0;
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            int currentInt = value(currentChar);
            
            if (i != length - 1) {
                char nextChar = s.charAt(i + 1);
                int nextInt = value(nextChar);
                
                if (nextInt > currentInt) {
                    currentInt = nextInt - currentInt;
                    i++;
                }
            }
            
            value += currentInt;
            
            
        }
        
        return value;
    }
    
    private int value(char let) {
        int num;
        
        switch (let) {
            case 'I': num = 1;
                break;
            case 'V': num = 5;
                break;
            case 'X': num = 10;
                break;
            case 'L': num = 50;
                break;
            case 'C': num = 100;
                break;
            case 'D': num = 500;
                break;
            case 'M': num = 1000;
                break;
            default: return 0;
                
        }
        
        return num;
    }
}