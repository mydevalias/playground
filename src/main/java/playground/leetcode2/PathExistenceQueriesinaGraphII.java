package playground.leetcode2;

import java.util.Arrays;

public class PathExistenceQueriesinaGraphII {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] connected = new int[n];

        Arrays.fill(connected, -1);
        for (int i = 0; i < n; i++) {
            if (connected[i] > -1) {
                continue;
            }

            bfs(n, maxDiff, i, i, connected, nums);
        }

        boolean res[] = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = connected[queries[i][0]] == connected[queries[i][1]];
        }
        return res;
    }

    private void bfs(int n, int maxDiff, int id, int current, int[] connected, int[] nums) {
        if (connected[current] > -1) {
            return;
        }
        connected[current] = id;
        for (int i = 0; i < n; i++) {
            if (i == current) {
                continue;
            }
            if (Math.abs(nums[i] - nums[current]) <= maxDiff) {
                bfs(n, maxDiff, id, i, connected, nums);
            }
        }
    }

}
