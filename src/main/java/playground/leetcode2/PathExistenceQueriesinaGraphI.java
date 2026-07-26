package playground.leetcode2;

import java.util.Arrays;

public class PathExistenceQueriesinaGraphI {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] connected = new int[n];

        Arrays.fill(connected, -1);
        for (int i = 0; i < n; i++) {
            if (connected[i] > -1) {
                continue;
            }

            dfs(n, maxDiff, i, i, connected, nums);
        }

        boolean res[] = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = connected[queries[i][0]] == connected[queries[i][1]];
        }
        return res;
    }

    private void dfs(int n, int maxDiff, int id, int current, int[] connected, int[] nums) {
        if (connected[current] > -1) {
            return;
        }
        connected[current] = id;
        if (current + 1 < n && Math.abs(nums[current + 1] - nums[current]) <= maxDiff) {
            dfs(n, maxDiff, id, current + 1, connected, nums);
        }
        if (current - 1 >= 0 && Math.abs(nums[current] - nums[current - 1]) <= maxDiff) {
            dfs(n, maxDiff, id, current - 1, connected, nums);
        }
    }

}
