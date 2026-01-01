package playground.leetcode;

public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        int ret = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[i].length - 3; j++) {
                if (isMagic(i, j, grid)) {
                    ret++;
                }
            }
        }
        return ret;
    }

    private boolean isMagic(int is, int js, int[][] grid) {
        int[] freq = new int[10];
        int sum = 0;

        for (int i = is; i < is + 3; i++) {
            for (int j = js; j < js + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9) {
                    return false;
                }
                freq[val]++;
                sum += val;
            }
        }

        if (sum != 45) return false;

        for (int i = 1; i <= 9; i++) {
            if (freq[i] != 1) return false;
        }

        for (int i = is; i < is + 3; i++) {
            if (grid[i][js] + grid[i][js + 1] + grid[i][js + 2] != 15) {
                return false;
            }
        }

        for (int j = js; j < js + 3; j++) {
            if (grid[is][j] + grid[is + 1][j] + grid[is + 2][j] != 15) {
                return false;
            }
        }

        if (grid[is][js] + grid[is + 1][js + 1] + grid[is + 2][js + 2] != 15) {
            return false;
        }
        if (grid[is][js + 2] + grid[is + 1][js + 1] + grid[is + 2][js] != 15) {
            return false;
        }

        return true;
    }

}
