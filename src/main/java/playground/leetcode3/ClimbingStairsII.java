package playground.leetcode3;

import java.util.Arrays;

public class ClimbingStairsII {

    int n;
    int[] costs;
    int[] memo;

    public int climbStairs(int n, int[] costs) {
        this.n = n;
        this.costs = costs;
        this.memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return bk(0);
    }

    private int bk(int i) {
        if (i == n) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int s1 = bk(i + 1) + costs[i] + 1;
        int s2 = Integer.MAX_VALUE;
        int s3 = Integer.MAX_VALUE;
        if (i + 2 <= n) {
            s2 = bk(i + 2) + costs[i + 1] + 4;
        }
        if (i + 3 <= n) {
            s3 = bk(i + 3) + costs[i + 2] + 9;
        }
        memo[i] = Math.min(Math.min(s1, s2), s3);
        return memo[i];
    }

}
