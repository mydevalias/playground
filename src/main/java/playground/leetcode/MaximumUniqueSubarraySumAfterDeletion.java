package playground.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description
 */
public class MaximumUniqueSubarraySumAfterDeletion {

    public int maxSum(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean valid = false;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (max < current) {
                max = current;
            }
            if (current < 0) {
                continue;
            }
            if (unique.add(current)) {
                sum += current;
                unique.add(current);
                valid = true;
            }
        }
        if (valid) {
            return sum;
        }
        return max;
    }

}
