package playground.leetcode2;

public class EqualSumGridPartitionI {

    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total += grid[i][j];
            }
        }

        long sum = 0;
        for (int j = 0; j < grid[0].length - 1; j++) {
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][j];
            }
            if (sum * 2 == total) {
                return true;
            }
        }

        sum = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
            if (sum * 2 == total) {
                return true;
            }

        }

        return false;
    }
}
