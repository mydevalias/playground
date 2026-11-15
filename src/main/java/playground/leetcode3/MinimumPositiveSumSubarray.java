package playground.leetcode3;

import java.util.List;

public class MinimumPositiveSumSubarray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.size() - l; i++) {
            int sum = 0;
            for (int j = i; j < Math.min(i + r, nums.size()); j++) {
                sum += nums.get(j);
                if (j - i + 1 >= l && sum > 0) {
                    minSum = Math.min(sum, minSum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

}
