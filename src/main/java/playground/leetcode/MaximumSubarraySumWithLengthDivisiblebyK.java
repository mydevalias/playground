package playground.leetcode;

public class MaximumSubarraySumWithLengthDivisiblebyK {
    public long maxSubarraySum(int[] nums, int k) {
        long ksums[] = new long[k];


        for (int i = 0; i < k; i++) {
            ksums[i] = Long.MAX_VALUE / 2;
        }
        ksums[k-1] =0;
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - ksums[i % k]);
            ksums[i % k] = Math.min(ksums[i % k], sum);
        }
        return maxSum;
    }


}
