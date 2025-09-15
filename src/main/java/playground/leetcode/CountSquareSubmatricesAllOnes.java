package playground.leetcode;

public class CountSquareSubmatricesAllOnes {

    public int countSquares(int[][] matrix) {
        int[][] totals = new int[matrix.length][matrix[0].length];
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            totals[i][0] = matrix[i][0];
            sum += totals[i][0];
        }
        for (int j = 0; j < matrix[0].length; j++) {
            totals[0][j] = matrix[0][j];
            if (j > 0) {
                sum += totals[0][j];
            }
        }

        for (int i = 1; i < totals.length; i++) {
            for (int j = 1; j < totals[0].length; j++) {
                if (matrix[i][j] == 1) {
                    totals[i][j] = 1 + Math.min(Math.min(totals[i - 1][j - 1], totals[i][j - 1]), totals[i - 1][j]);
                    sum += totals[i][j];
                }
            }
        }
        return sum;
    }

}
