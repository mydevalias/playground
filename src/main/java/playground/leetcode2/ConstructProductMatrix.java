package playground.leetcode2;

public class ConstructProductMatrix {

    private final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int res[][] = new int[grid.length][grid[0].length];
        long suffix = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                res[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }
        long pref = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res[i][j] = (int) ((pref * res[i][j]) % MOD);
                pref = (pref * grid[i][j]) % MOD;
            }
        }
        return res;
    }

}
