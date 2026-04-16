package playground.leetcode2;

public class MinimumDistanceTotheTargetElement {


    public int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int c = Math.abs(i - start);
                res = Math.min(res, c);
            }
        }
        return res;
    }
}
