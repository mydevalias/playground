package playground.leetcode3;

public class StoneGameII {

    int[] piles;
    Integer[][][] memo;

    public int stoneGameII(int[] piles) {
        this.piles = piles;
        int n = piles.length;
        memo = new Integer[n][n + 1][2];
        return bk(0, 1, true);
    }

    private int bk(int i, int M, boolean alice) {
        if (i >= piles.length) {
            return 0;
        }
        if (memo[i][M][alice ? 1 : 0] != null) {
            return memo[i][M][alice ? 1 : 0];
        }
        int result;
        if (alice) {
            int best = 0;
            int taken = 0;
            for (int x = 1; x <= 2 * M && i + x - 1 < piles.length; x++) {
                taken += piles[i + x - 1];
                int s = bk(i + x, Math.max(M, x), false) + taken;
                best = Math.max(best, s);
            }
            result = best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int x = 1; x <= 2 * M && i + x - 1 < piles.length; x++) {
                int s = bk(i + x, Math.max(M, x), true);
                best = Math.min(best, s);
            }
            result = best;
        }
        memo[i][M][alice ? 1 : 0] = result;
        return result;
    }


}
