package playground.leetcode;

public class TrionicArrayII {

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        int mm = 0;
        while (mm < n) {
            int l = mm;
            int i = l + 1;
            while (i < n && nums[i - 1] < nums[i]) {
                i++;
            }
            int p = i - 1;
            while (i < n && nums[i - 1] > nums[i]) {
                i++;
            }
            int q = i - 1;
            while (i < n && nums[i - 1] < nums[i]) {
                i++;
            }
            int r = i - 1;
            if (q == p || r == q) {  // Fixed condition
                mm = q + 1;
                continue;
            }
            max = Math.max(max, findMax(nums, l, p, q, r));
            mm = q + 1;  // Fixed increment
        }
        return max;
    }

    private long findMax(int[] nums, int l, int p, int q, int r) {
        long res = 0;
        //first
        long maxSum = 0;
        long sum = 0;
        for (int i = p - 1; i >= l; i--) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        res += maxSum;
        //second
        for (int i = p; i <= q; i++) {
            res += nums[i];
        }
        //third
        maxSum = 0;
        sum = 0;
        for (int i = q + 1; i <= r; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        res += maxSum;

        return res;
    }

}
