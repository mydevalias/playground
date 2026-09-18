package playground.leetcode3;

import java.util.Arrays;

public class FindTwoNonoverlappingSubArraysEachWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] bestEndingBy = new int[n]; // bestEndingBy[i] = shortest valid window ending at or before i
        Arrays.fill(bestEndingBy, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int len = i - left + 1;
                if (left > 0 && bestEndingBy[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, bestEndingBy[left - 1] + len);
                }
                bestEndingBy[i] = len;
            }
            if (i > 0) {
                bestEndingBy[i] = Math.min(bestEndingBy[i], bestEndingBy[i - 1]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
