package playground.leetcode3;

public class MinimumOperationstoReduceXtoZero {

    private int[] nums;

    public int minOperations(int[] nums, int x) {
        this.nums = nums;
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
        if (x == 0) {
            return 0;
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
        return min;
    }

}
