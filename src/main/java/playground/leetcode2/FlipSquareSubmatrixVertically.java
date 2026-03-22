package playground.leetcode2;

public class FlipSquareSubmatrixVertically {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int j = y ; j < y + k / 2; j++) {
            int e =1;
            for (int i = x; i < x + k; i++) {
                int tmp = grid[i][j];
                grid[i][j] = grid[i-e][j];
                grid[i-e][j] = tmp;
                e++;
            }
        }
        return grid;
    }

}
