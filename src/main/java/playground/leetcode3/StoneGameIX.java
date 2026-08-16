package playground.leetcode3;

public class StoneGameIX {


    private int[] cnt;
    private Boolean[][][][][] memo;

    public boolean stoneGameIX(int[] stones) {
        cnt = counts(stones);
        memo = new Boolean[2][3][cnt[0] + 1][cnt[1] + 1][cnt[2] + 1];
        return bk(true, 0, cnt[0], cnt[1], cnt[2]);
    }

    private boolean bk(boolean aliceTurn, int sumMod, int c0, int c1, int c2) {
        if (c0 == 0 && c1 == 0 && c2 == 0) {
            return false;
        }

        int t = aliceTurn ? 1 : 0;
        if (memo[t][sumMod][c0][c1][c2] != null) {
            return memo[t][sumMod][c0][c1][c2];
        }

        boolean result;
        if (aliceTurn) {
            boolean r0 = false, r1 = false, r2 = false;
            if (c0 > 0) {
                int newSum = (sumMod + 0) % 3;
                r0 = (newSum == 0) ? false : bk(false, newSum, c0 - 1, c1, c2);
            }
            if (c1 > 0) {
                int newSum = (sumMod + 1) % 3;
                r1 = (newSum == 0) ? false : bk(false, newSum, c0, c1 - 1, c2);
            }
            if (c2 > 0) {
                int newSum = (sumMod + 2) % 3;
                r2 = (newSum == 0) ? false : bk(false, newSum, c0, c1, c2 - 1);
            }
            result = r0 || r1 || r2;
        } else {
            boolean r0 = true, r1 = true, r2 = true;
            if (c0 > 0) {
                int newSum = (sumMod + 0) % 3;
                r0 = (newSum == 0) ? true : bk(true, newSum, c0 - 1, c1, c2);
            }
            if (c1 > 0) {
                int newSum = (sumMod + 1) % 3;
                r1 = (newSum == 0) ? true : bk(true, newSum, c0, c1 - 1, c2);
            }
            if (c2 > 0) {
                int newSum = (sumMod + 2) % 3;
                r2 = (newSum == 0) ? true : bk(true, newSum, c0, c1, c2 - 1);
            }
            result = r0 && r1 && r2;
        }

        memo[t][sumMod][c0][c1][c2] = result;
        return result;
    }

    private int[] counts(int[] stones) {
        int cnt[] = new int[3];
        for (int val : stones) {
            cnt[val % 3]++;
        }
        return cnt;
    }
}
