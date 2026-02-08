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
            if (q == p || r == q || p == l ) {
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

        for (int i = p; i <= q; i++) {
            res += nums[i];
        }

        long maxSum = nums[p - 1];  // Must include this
        long sum = nums[p - 1];
        for (int k = p - 2; k >= l; k--) {
            sum += nums[k];
            maxSum = Math.max(maxSum, sum);
        }
        res += maxSum;

        maxSum = nums[q + 1];  // Must include this
        sum = nums[q + 1];
        for (int k = q + 2; k <= r; k++) {
            sum += nums[k];
            maxSum = Math.max(maxSum, sum);
        }
        res += maxSum;

        return res;
    }

}
