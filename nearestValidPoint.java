/**
 * taken: https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 *
 */

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        // Priority: manhtaan distance and then index.

        // manhattan distance:
        // abs(x1 - x2) + abs(y1 - y2)

        int index = - 1;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int newDistance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);

                if (newDistance < distance) {
                    distance = newDistance;
                    index = i;
                }
            }
        }
        return index;
    }
}