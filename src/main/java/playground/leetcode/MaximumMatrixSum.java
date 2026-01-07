package playground.leetcode;

public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        long min = Long.MAX_VALUE;
        long sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    count++;
                }
                long current = Math.abs(matrix[i][j]);
                min = Math.min(current, min);
                sum += current;
            }
        }

        if (count % 2 == 0) {
            return sum;
        }
        return sum - 2 * min;
    }


    public static void main(String[] args) {
        System.out.println(new MaximumMatrixSum().maxMatrixSum(new int[][]{{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}}));
    }
}
