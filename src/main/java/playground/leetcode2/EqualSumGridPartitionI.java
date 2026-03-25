package playground.leetcode2;

public class EqualSumGridPartitionI {

    public boolean canPartitionGrid(int[][] grid) {
        long[][] sumsPrefix = new long[grid.length][grid[0].length];
        long[][] sumsSuffix = new long[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            long sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                sumsPrefix[i][j] = sum;
            }
            sum = 0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                sum += grid[i][j];
                sumsSuffix[i][j] = sum;
            }
        }

        for (int j = 1; j < grid[0].length; j++) {
            boolean found = true;
            for (int i = 0; i < grid.length; i++) {
                if (sumsPrefix[i][j - 1] != sumsSuffix[i][j]) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }

        sumsPrefix = new long[grid.length][grid[0].length];
        sumsSuffix = new long[grid.length][grid[0].length];

        for (int j = 0; j < grid[0].length; j++) {
            long sum = 0;
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][j];
                sumsPrefix[i][j] = sum;
            }
            sum = 0;
            for (int i = grid.length - 1; i >= 0; i--) {
                sum += grid[i][j];
                sumsSuffix[i][j] = sum;
            }
        }

        for (int i = 1; i < grid.length; i++) {
            boolean found = true;
            for (int j = 0; j < grid[0].length; j++) {
                if (sumsPrefix[i - 1][j] != sumsSuffix[i][j]) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }

        return false;
    }

}
