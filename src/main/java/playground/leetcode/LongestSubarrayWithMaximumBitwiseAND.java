package playground.leetcode;

/**
 * https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description
 */
public class LongestSubarrayWithMaximumBitwiseAND {

    public int longestSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int currentLen = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max && nums[i] == nums[i - 1]) {
                currentLen++;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
                continue;
            } else {
                currentLen = 1;
            }
            if (max < nums[i]) {
                max = nums[i];
                maxLen = 1;
            }
        }
        return maxLen;
    }
}
