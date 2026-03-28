package playground.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInSlidingSubmatrix {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n - k + 1][m - k + 1];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                List<Integer> values = kArrays(grid, k, i, j);
                ans[i][j] = minDifference(values);
            }
        }
        return ans;
    }

    private int minDifference(List<Integer> values) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i).equals(values.get(i + 1))) {
                continue;
            }
            min = Math.min(min, Math.abs(values.get(i) - values.get(i + 1)));
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    private static List<Integer> kArrays(int[][] grid, int k, int i, int j) {
        List<Integer> values = new ArrayList<>(k * k);
        for (int ii = i; ii < i + k; ii++) {
            for (int jj = j; jj < j + k; jj++) {
                values.add(grid[ii][jj]);
            }
        }
        values.sort(Integer::compareTo);
        return values;
    }

}
