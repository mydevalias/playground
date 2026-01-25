package playground.leetcode;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i]+nums[nums.length-i-1]);
        }
        return max;
    }

}
