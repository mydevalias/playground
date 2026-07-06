package playground.leetcode2;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumScoreofaPathBetweenTwoCities {

    public int minScore(int n, int[][] roads) {
        int[] parent = new int[n + 1];
        int[] min = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            min[i] = Integer.MAX_VALUE;
        }

        for (int road[] : roads) {
            int f = road[0];
            int t = road[1];
            int d = road[2];

            union(parent, min, f, t, d);
        }

        int root = find(parent, 1);
        return min[root];
    }

    private void union(int[] parent, int[] min, int f, int t, int d) {
        int rf = find(parent, f);
        int rt = find(parent, t);

        if (rf != rt) {
            parent[rf] = rt;
            min[rt] = Math.min(min[rt], min[rf]);
        }

        min[find(parent, f)] = Math.min(min[find(parent, f)], d);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
