package playground.leetcode;

public class FindMinimumAreaCoverAllOnes {

    public int minimumArea(int[][] grid) {
        int m = grid[0].length;
        if (grid.length == 0) {
            return 0;
        }
        if (m == 0) {
            return 0;
        }
        int min_i = Integer.MAX_VALUE;
        int min_j = Integer.MAX_VALUE;
        int max_i = -1;
        int max_j = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    min_i = Math.min(i, min_i);
                    min_j = Math.min(j, min_j);
                    max_i = Math.max(i, max_i);
                    max_j = Math.max(j, max_j);
                }
            }
        }
        int length = max_i - min_i + 1;
        int width = max_j - min_j + 1;
        return length * width;
    }

}
