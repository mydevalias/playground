package playground.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int size = grid.length * grid[0].length;
        List<Integer> all = new ArrayList<>(size);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                all.add(grid[i][j]);
            }
        }
        k %= size;
        int flatpos = 0;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> c = new ArrayList<>();
            ret.add(c);
            for (int j = 0; j < grid[i].length; j++) {
                int srcIdx = (flatpos - k) % size;
                if (srcIdx < 0) {
                    srcIdx += size;
                }
                c.add(all.get(srcIdx));
                flatpos++;
            }
        }
        return ret;

    }
}
