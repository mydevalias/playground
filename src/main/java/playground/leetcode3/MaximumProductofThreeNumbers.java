package playground.leetcode3;

import java.util.Arrays;

public class MaximumProductofThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > 0) {
            //at least one positive
            int p1 = nums[n - 2] * nums[n - 3];
            int p2 = nums[0] * nums[1];
            if (p1 > p2) {
                return p1 * nums[n - 1];
            } else {
                return p2 * nums[n - 2];
            }
        }
        return nums[n - 1] * nums[n - 2] * nums[n - 3];

    }

}
