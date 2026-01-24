package playground.leetcode;

//https://leetcode.com/problems/minimum-time-visiting-all-points/description
public class MinimumTimeVisitingAllPoints {


    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] current = points[i];
            int[] next = points[i + 1];
            int minDis = Math.max(Math.abs(current[0] - next[0]), Math.abs(current[1] - next[1]));
            sum += minDis;
        }
        return sum;
    }
}
