package playground.leetcode;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if (i > 0) {
                    up = grid[i - 1][j];
                }
                if (j > 0) {
                    left = grid[i][j - 1];
                }
                grid[i][j] = grid[i][j] + Math.min(left, up);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
