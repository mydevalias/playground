package playground.leetcode2;

public class MaximumTotalSubarrayValueI {

    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        return (long) k * (max - min);
    }

}
