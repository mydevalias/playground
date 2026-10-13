package playground.leetcode3;

public class StoneGameIII {

    int[] stoneValue;
    Integer[][] memo;

    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue;
        memo = new Integer[stoneValue.length + 1][2];
        int delta = pdw(0, stoneValue.length, true);
        if (delta > 0) return "Alice";
        if (delta < 0) return "Bob";
        return "Tie";
    }

    private int pdw(int start, int end, boolean playerOne) {
        if (start == end) {
            return 0;
        }
        int idx = playerOne ? 0 : 1;
        if (memo[start][idx] != null) {
            return memo[start][idx];
        }
        int result = playerOne ? maxTake(start, end) : minTake(start, end);
        memo[start][idx] = result;
        return result;
    }

    private int maxTake(int start, int end) {
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for (int take = 1; take <= 3 && start + take <= end; take++) {
            sum += stoneValue[start + take - 1];
            int candidate = sum + pdw(start + take, end, false);
            best = Math.max(best, candidate);
        }
        return best;
    }

    private int minTake(int start, int end) {
        int best = Integer.MAX_VALUE;
        int sum = 0;
        for (int take = 1; take <= 3 && start + take <= end; take++) {
            sum += stoneValue[start + take - 1];
            int candidate = pdw(start + take, end, true) - sum;
            best = Math.min(best, candidate);
        }
        return best;
    }

}
