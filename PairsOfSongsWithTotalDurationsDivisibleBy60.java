/**
 * Taken from: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 *You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 *Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 */

class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        // new array[60] where we increment the index at time[i] % 60
        // the go through half the array. and check if there is a matching value
        // tally that.
        final int DIVISIBLE_BY = 60;
        
        int[] module = new int[DIVISIBLE_BY];
        int pairs = 0;
        
        for (int i = 0; i < time.length; i++) {
            module[time[i] % DIVISIBLE_BY]++;
        }
        
        for (int i = 0; i <= (DIVISIBLE_BY / 2); i++){
            
            if (module[i] == 0){
                continue;
            }
            
            if (i == 0 || i == 30) {
                
                if(module[i] > 1){
                    pairs += module[i] * (module[i] - 1) / 2;
                }
                
            } else {
                
                int match = DIVISIBLE_BY - i;
                
                if (module[match] != 0) {
                    pairs += module[i] * module[match];
                    
                }
            }
        }
        
        return pairs;
    }
}