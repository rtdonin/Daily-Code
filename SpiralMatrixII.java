/**
 * Taken from: https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * 
 */

class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];

        boolean across = true; // true is moving across a row, false is moving along a column;

        int iAdd = 1;
        int jAdd = 1;

        int i = 0;
        int j = 0;

        boolean twoSides = true;
        int squared = n * n;
        int steps = n;
        int stepsTaken = 0;

        for (int count = 1; count <= squared; count++) {
            array[i][j] = count;
            stepsTaken++;
            
            if (across) {
                j += jAdd;
                
            } else {
                i += iAdd;
            }

            if (stepsTaken == steps) {
                stepsTaken = 0;
                
                if (twoSides) {
                    steps--;
                }
                
                across = !across;
                
                if (across) {
                    iAdd *= -1;
                } else {
                    jAdd *= -1;
                }
                
                i += iAdd;
                j += jAdd;
                
                twoSides = !twoSides;

            }

        }

        return array;
    }
}