package playground.leetcode;

public class CountNumberMaximumBitwiseORSubsets {
    int maxCount = 0;
    int maxValue = 0;
    int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        int or = 0;
        for (int val : nums) {
            or = or | val;
        }
        maxValue = or;
        dfs(0, 0);
        return maxCount;
    }

    private void dfs(int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxValue) {
                maxCount++;
            }
            return;
        }
        dfs(index + 1, currentOr);
        dfs(index + 1, currentOr | nums[index]);
    }

}
