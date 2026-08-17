package playground.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class StoneGameIX {


    private Map<Long, Boolean> memo = new HashMap<>();

    public boolean stoneGameIX(int[] stones) {
        int[] cnt = counts(stones);
        boolean flag = (cnt[0] % 2 == 1);
        return bk(true, 0, cnt[1], cnt[2], flag);
    }

    private long key(boolean aliceTurn, int sumMod, int c1, int c2, boolean flag) {
        long k = aliceTurn ? 1 : 0;
        k = k * 3 + sumMod;
        k = k * 100000 + c1;
        k = k * 100000 + c2;
        k = k * 2 + (flag ? 1 : 0);
        return k;
    }

    private boolean bk(boolean aliceTurn, int sumMod, int c1, int c2, boolean flag) {
        if (c1 == 0 && c2 == 0 && !flag) {
            return false;
        }

        long k = key(aliceTurn, sumMod, c1, c2, flag);
        Boolean cached = memo.get(k);
        if (cached != null) {
            return cached;
        }

        boolean result;
        if (aliceTurn) {
            boolean r0 = false, r1 = false, r2 = false;
            if (flag) {
                int newSum = sumMod;
                r0 = (newSum == 0) ? false : bk(false, newSum, c1, c2, false);
            }
            if (c1 > 0) {
                int newSum = (sumMod + 1) % 3;
                r1 = (newSum == 0) ? false : bk(false, newSum, c1 - 1, c2, flag);
            }
            if (c2 > 0) {
                int newSum = (sumMod + 2) % 3;
                r2 = (newSum == 0) ? false : bk(false, newSum, c1, c2 - 1, flag);
            }
            result = r0 || r1 || r2;
        } else {
            boolean r0 = true, r1 = true, r2 = true;
            if (flag) {
                int newSum = sumMod;
                r0 = (newSum == 0) ? true : bk(true, newSum, c1, c2, false);
            }
            if (c1 > 0) {
                int newSum = (sumMod + 1) % 3;
                r1 = (newSum == 0) ? true : bk(true, newSum, c1 - 1, c2, flag);
            }
            if (c2 > 0) {
                int newSum = (sumMod + 2) % 3;
                r2 = (newSum == 0) ? true : bk(true, newSum, c1, c2 - 1, flag);
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
