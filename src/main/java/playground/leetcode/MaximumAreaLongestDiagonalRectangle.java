package playground.leetcode;

public class MaximumAreaLongestDiagonalRectangle {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = -1;
        int maxDig = -1;
        for (int i = 0; i < dimensions.length; i++) {
            var currentDig = dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1];
            if (currentDig > maxDig) {
                maxDig = currentDig;
                maxArea = dimensions[i][0] * dimensions[i][1];
            } else {
                if (currentDig == maxDig) {
                    maxArea = Math.max(maxArea, dimensions[i][0] * dimensions[i][1]);
                }
            }
        }
        return maxArea;
    }

}
