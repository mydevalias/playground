package playground.leetcode3;

public class MinimumMovestoEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int val : nums) {
            min = Math.min(val, min);
        }

        int ret = 0;
        for (int num : nums) {
            ret += num - min;
        }
        return ret;
    }

}
