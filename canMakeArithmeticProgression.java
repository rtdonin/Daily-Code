/**
 * taken from: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 * 
 */

 // This solution is slow and memory consuming.
 // There is probably a better way to do it.
 // I will be looking into it.

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        double aSum = 0;
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;

        Set<Double> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            int current = arr[i];
            aSum += current;

            set.add(new Double(current));

            if (current > max) {
                max = current;
            }

            if (current < min) {
                min = current;
            }
        }

        double tSum = arr.length * (min + max) / 2.0;

        if (aSum != tSum) {
            return false;
        }

        double d = (max - min) / (arr.length - 1.0);

        System.out.println("tSum: " + tSum + " aSum: " + aSum + " min: " + min + " max: " + max + " length: " + arr.length + " diff: " + d);

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(min + d * i)) {
                return false;
            }

        }

        return true;
    }
}

// The quicker solution is just to sort the array.
// I was wondering if that was the case.
// This makes perfect sense.

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        Arrays.sort(arr);
        int d = Math.abs(arr[1] - arr[0]);

        for(int i = 1; i< arr.length; i++){
            if(Math.abs(arr[i] - arr[i - 1]) != d) {
                return false;
            }
        }
        return true;
        
    }
}