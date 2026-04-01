package playground.leetcode2;

import java.util.HashMap;

public class EqualSumGridPartitionII {

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;
        CountMap remaining = buildCountMap(grid, m, n);
        total = sumall(grid, m, n, total);

        long sum = 0;
        CountMap current = new CountMap();
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                current.add(grid[i][j]);
                remaining.remove(grid[i][j]);
                sum += grid[i][j];
            }
            long other = total - sum;
            if (other == sum) {
                return true;
            }
            long d = Math.abs(other - sum);
            if (other > sum && remaining.contains((int) d)) {
                if (j < n - 2) {
                    return true;
                }
                if (grid[0][j + 1] == d || grid[0][n - 1] == d) {
                    return true;
                }
            }
            if (sum > other && current.contains((int) d)) {
                if (j > 0) {
                    return true;
                }
                if (grid[0][0] == d || grid[0][j] == d) {
                    return true;
                }
            }
        }

        sum = 0;
        current = new CountMap();
        remaining = buildCountMap(grid, m, n);

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                current.add(grid[i][j]);
                remaining.remove(grid[i][j]);
                sum += grid[i][j];
            }
            long other = total - sum;
            if (other == sum) {
                return true;
            }
            long d = Math.abs(other - sum);
            if (other > sum && remaining.contains((int) d)) {
                if (i < m - 2) {
                    return true;
                }
                if (grid[i + 1][0] == d || grid[m - 1][0] == d) {
                    return true;
                }
            }
            if (sum > other && current.contains((int) d)) {
                if (i > 0) {
                    return true;
                }
                if (grid[0][0] == d || grid[i][0] == d) {
                    return true;
                }
            }
        }

        return false;
    }

    private static long sumall(int[][] grid, int m, int n, long total) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        return total;
    }

    private CountMap buildCountMap(int[][] grid, int m, int n) {
        CountMap remaining;
        remaining = new CountMap();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                remaining.add(grid[i][j]);
            }
        }
        return remaining;
    }

    class CountMap {
        private final HashMap<Integer, Integer> map = new HashMap<>();

        public boolean contains(int val) {
            return map.containsKey(val);
        }

        public void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        public void remove(int val) {
            int count = map.getOrDefault(val, 0);
            if (count <= 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }
    }
}
