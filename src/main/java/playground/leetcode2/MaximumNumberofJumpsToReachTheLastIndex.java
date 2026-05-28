package playground.leetcode2;

import java.util.Arrays;

public class MaximumNumberofJumpsToReachTheLastIndex {

    private int[] nums;
    private int target;
    private int[] cache;

    public int maximumJumps(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.cache = new int[nums.length];
        Arrays.fill(cache, -2);
        return bkMax(0);
    }

    private int bkMax(int pos) {
        if (pos == nums.length - 1) {
            return 0;
        }
        if (cache[pos] > -2) {
            return cache[pos];
        }

        int bm = -1;
        for (int j = pos + 1; j < nums.length; j++) {
            int dif = nums[j] - nums[pos];
            if (-target <= dif && dif <= target) {
                int t = bkMax(j);
                if (t == -1) {
                    continue;
                }
                bm = Math.max(bm, t + 1);
            }
        }
        cache[pos] = bm;
        return bm;
    }

}
