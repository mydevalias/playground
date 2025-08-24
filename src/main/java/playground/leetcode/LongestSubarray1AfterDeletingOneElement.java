package playground.leetcode;

public class LongestSubarray1AfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int prev = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (current == 0 && prev > 0) {
                    prev = 0;
                }
                if (current > 0) {
                    prev = current;
                }
                current = 0;
            } else {
                current++;
                max = Math.max(prev + current, max);
            }
        }

        if (max == nums.length) {
            max--;
        }
        return max;
    }

}
