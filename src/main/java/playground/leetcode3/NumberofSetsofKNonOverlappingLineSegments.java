package playground.leetcode3;

public class NumberofSetsofKNonOverlappingLineSegments {
    private static final int MOD = 1_000_000_007;
    private Integer[][] memo;

    public int numberOfSets(int n, int k) {
        memo = new Integer[n + 1][k + 1];
        return bk(n-1, k);
    }

    private int bk(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (n < 1) {
            return 0;
        }
        if (memo[n][k] != null) {
            return memo[n][k];
        }

        int ret = bk(n - 1, k); // current is not used

        //current is used as end segment
        for (int i = 0; i < n; i++) {
            ret = (ret + bk(i, k - 1)) % MOD;
        }

        memo[n][k] = ret;
        return ret;
    }

}
