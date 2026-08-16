package playground.leetcode3;

import java.util.Map;

public class StoneGameIX {


    private Map<Long, Boolean> memo;

    public boolean stoneGameIX(int[] stones) {
        int[] cnt = counts(stones);
        memo = new java.util.HashMap<>();
        return bk(true, 0, cnt[0], cnt[1], cnt[2]);
    }

    private long key(boolean aliceTurn, int sumMod, int c0, int c1, int c2) {
        long k = aliceTurn ? 1 : 0;
        k = k * 3 + sumMod;
        k = k * 100000 + c0;
        k = k * 100000 + c1;
        k = k * 100000 + c2;
        return k;
    }

    private boolean bk(boolean aliceTurn, int sumMod, int c0, int c1, int c2) {
        if (c0 == 0 && c1 == 0 && c2 == 0) {
            return false;
        }

        long k = key(aliceTurn, sumMod, c0, c1, c2);
        Boolean cached = memo.get(k);
        if (cached != null) {
            return cached;
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

        memo.put(k, result);
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
