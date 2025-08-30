package playground.leetcode;

import java.util.Arrays;

public class SortMatrixDiagonals {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[] current = new int[n];

        for (int i = 1; i < n; i++) {
            int len = 0;
            int j = 0;
            while (i + j < n) {
                current[len++] = grid[j][i + j];
                j++;
            }

            Arrays.sort(current, 0, len);
            j = 0;
            while (i + j < n) {
                grid[j][i + j] = current[j];
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            int len = 0;
            int j = 0;
            while (i + j < n) {
                current[len++] = grid[i + j][j];
                j++;
            }
            Arrays.sort(current, 0, len);
            for (int k = 0; k < len / 2; k++) {
                int temp = current[k];
                current[k] = current[len - 1 - k];
                current[len - 1 - k] = temp;
            }

            j = 0;
            while (i + j < n) {
                grid[i + j][j] = current[j];
                j++;
            }
        }
        return grid;
    }


}
