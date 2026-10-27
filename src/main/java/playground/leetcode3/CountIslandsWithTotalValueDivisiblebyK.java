package playground.leetcode3;

public class CountIslandsWithTotalValueDivisiblebyK {
    boolean visited[][];
    int[][] grid;
    public int countIslands(int[][] grid, int k) {
        visited = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (grid[i][j] == 0) {
                   continue;
                }
                long sum = df(i, j);
                if (sum > 0 && sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private long df(int i, int j) {
        if (i < 0 || i >= grid.length) {
            return 0;
        }
        if (j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return grid[i][j] + df(i + 1, j) + df(i - 1, j) +
                df(i, j + 1) + df(i, j - 1);
    }

}
