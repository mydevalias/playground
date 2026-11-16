package playground.leetcode3;

import java.util.Arrays;

public class NumberofSubArraysWithOddSum {

    int[] arr;
    int[][] memo;

    public int numOfSubarrays(int[] arr) {
        this.arr = arr;
        this.memo = new int[arr.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret = (ret + bk(i, true)) % 1_000_000_007;
        }
        return ret;
    }

    int bk(int pos, boolean needOdd) {
        if (pos == arr.length) {
            return 0;
        }
        int col = needOdd ? 1 : 0;
        if (memo[pos][col] != -1) {
            return memo[pos][col];
        }

        boolean nextNeedOdd;
        if (arr[pos] % 2 == 1) {
            nextNeedOdd = !needOdd;
        } else {
            nextNeedOdd = needOdd;
        }

        int goOn = bk(pos + 1, nextNeedOdd);
        if (arr[pos] % 2 == 1 == needOdd) {
            memo[pos][col] = 1 + goOn;
        } else {
            memo[pos][col] = goOn;
        }
        return memo[pos][col];
    }
}
