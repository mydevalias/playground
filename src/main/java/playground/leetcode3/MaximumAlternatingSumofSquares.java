package playground.leetcode3;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/?envType=daily-question&envId=2026-10-13
 */
public class MaximumAlternatingSumofSquares {
    public long maxAlternatingSum(int[] nums) {
        long[] all = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            all[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(all);
        long res = 0;
        for (int i = 0; i < nums.length / 2; i++) {

            res += all[nums.length - i - 1] - all[i];
        }
        if (nums.length % 2 == 1) {
            res += all[nums.length / 2];
        }
        return res;
    }

}
