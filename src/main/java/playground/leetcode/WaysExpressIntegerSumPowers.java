package playground.leetcode;

public class WaysExpressIntegerSumPowers {

    final int MOD = 1_000_000_007;
    private Integer[][] memo;

    public int numberOfWays(int n, int x) {
        memo = new Integer[n + 1][n + 1];
        return canSum(n, x, 1);
    }

    private int canSum(int target, int x, int currentBase) {
        if (memo[target][currentBase] != null) {
            return memo[target][currentBase];
        }

        if (target == 0) {
            return 1;
        }

        long currentPower = (long) Math.pow(currentBase, x);
        if (currentPower > target) {
            return 0;
        }

        int result = (canSum((int) (target - currentPower), x, currentBase + 1) +
                canSum(target, x, currentBase + 1)) % MOD;

        return memo[target][currentBase] = result;
    }
}
