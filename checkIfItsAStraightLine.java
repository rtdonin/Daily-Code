/**
 * taken from: https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */

// initial solution
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slope = calculateSlope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        double temp;

        for (int i = 1; i < coordinates.length - 1; i++){
            temp = calculateSlope(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0], coordinates[i + 1][1]);

            System.out.println("slope: " + slope + " temp: " + temp);

            if (slope != temp) {
                // verticle line check
                if (coordinates[0][0] == coordinates[i][0] && coordinates[0][0] == coordinates[i + 1][0]) {
                    continue;
                }
                return false;
            }
        }

        return true;        
    }

    double calculateSlope(int x1, int y1, int x2, int y2) {
        return (double) (y1 - y2) /(x1 - x2);
    }
}

// better solution
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int xDiff = coordinates[0][0] - coordinates[1][0];
        int yDiff = coordinates[0][1] - coordinates[1][1];

        for (int i = 1; i < coordinates.length - 1; i++){
            if (xDiff * (coordinates[i][1] - coordinates[i + 1][1]) != yDiff * (coordinates[i][0] - coordinates[i + 1][0])){
                return false;
                    }
        }

        return true;
    }
}