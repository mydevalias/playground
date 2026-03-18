package playground.leetcode2;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        int res = 0;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; i++) {
            int c = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0) {
                    c = 0;
                } else {
                    c += matrix[j][i];
                    matrix[j][i] = c;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i].clone();
            Arrays.sort(row);
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, row[j] * (cols - j));
            }
        }

        return res;
    }

}
