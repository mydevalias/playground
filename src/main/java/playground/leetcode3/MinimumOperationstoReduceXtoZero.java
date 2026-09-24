package playground.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationstoReduceXtoZero {

    private int[] nums;
    private Integer[][] memo;
    private int best;

    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> suffix = new HashMap<>();
        suffix.put(0, nums.length);
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            suffix.put(sum, i);
        }

        int min = Integer.MAX_VALUE;
        if (suffix.containsKey(x)) {
            min = nums.length - suffix.get(x);
        }
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int need = x - sum;
            if (suffix.containsKey(need) && suffix.get(need) > i) {
                min = Math.min(min, (i + 1) + (nums.length - suffix.get(need)));
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public int slowMinOperations(int[] nums, int x) {
        this.nums = nums;
        this.memo = new Integer[nums.length + 1][nums.length + 1];
        this.best = nums.length + 1;
        int bk = bk(x, 0, nums.length);
        if (bk > nums.length) {
            return -1;
        }
        return bk;
    }

    private int bk(int x, int start, int end) {
        if (x < 0) {
            return this.nums.length + 1;
        }
        int opsSoFar = start + (this.nums.length - end);
        if (x == 0) {
            best = Math.min(best, opsSoFar);
            return 0;
        }
        if (opsSoFar >= best) {
            return this.nums.length + 1;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        int min = this.nums.length + 1;
        int current = x;
        for (int i = start; i < end; i++) {
            current -= nums[i];
            min = Math.min(min, (i - start + 1) + bk(current, i + 1, end));
        }
        current = x;
        for (int i = end - 1; i >= start; i--) {
            current -= nums[i];
            min = Math.min(min, (end - i) + bk(current, start, i));
        }
        memo[start][end] = min;
        return min;
    }

}
