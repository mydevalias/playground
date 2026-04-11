package playground.leetcode2;

public class MinimumDistanceBetweenThreeEqualElementsI {

    public int minimumDistance(int[] nums) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        ret = Math.min(ret, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
                    }
                }
            }
        }

        if (ret == Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }

}
