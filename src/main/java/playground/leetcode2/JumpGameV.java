package playground.leetcode2;

import java.util.Arrays;

public class JumpGameV {
    private int[] arr;
    private int d;
    private int[] cache;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        int max = 0;
        this.cache = new int[this.arr.length];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(bk(i), max);
        }
        return max;
    }

    public int bk(int pos) {
        if (cache[pos] > 0) {
            return cache[pos];
        }
        int max = 1;
        int guard = arr[pos];

        for (int i = pos - 1; i >= Math.max(pos - d, 0); i--) {
            if (guard > arr[i]) {
                max = Math.max(max, bk(i) + 1);
            } else {
                break;
            }
        }

        for (int i = pos + 1; i <= Math.min(pos + d, arr.length - 1); i++) {
            if (guard > arr[i]) {
                max = Math.max(max, bk(i) + 1);
            } else {
                break;
            }
        }
        cache[pos] = max;
        return max;
    }

}
