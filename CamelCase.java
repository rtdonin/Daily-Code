/**
 * taken from: https://www.hackerrank.com/challenges/camelcase/problem
 */

class Result {

    /*
     * Complete the 'camelcase' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int camelcase(String s) {
    // Write your code here
        int words = 1;
        
        int A = Character.valueOf('A');
        int Z = Character.valueOf('Z');
        
        for(char c : s.toCharArray()) {
            int val = Character.valueOf(c);
            if (A <= val && val <= Z) {
                words++;
            }
        }
        
        return words;
    }

}