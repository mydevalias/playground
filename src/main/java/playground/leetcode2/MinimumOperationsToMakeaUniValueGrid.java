package playground.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumOperationsToMakeaUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        List<Integer> all = getIntegers(grid);
        Collections.sort(all);
        int des = all.get(all.size() / 2);
        int res = 0;
        for (int el : all) {
            if (des % x != el % x) {
                return -1;
            }
            res = res + Math.abs(des - el) / x;
        }
        return res;
    }

    private static List<Integer> getIntegers(int[][] grid) {
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                all.add(grid[i][j]);
            }
        }
        return all;
    }
}
