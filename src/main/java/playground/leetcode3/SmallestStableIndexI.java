package playground.leetcode3;

public class SmallestStableIndexI {
    public int firstStableIndex(int[] nums, int k) {
        int[] mins = new int[nums.length];
        int min = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            mins[i] = min;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            int score = max - mins[i];
            if (score <= k) {
                return i;
            }
        }
        return -1;

    }

}
