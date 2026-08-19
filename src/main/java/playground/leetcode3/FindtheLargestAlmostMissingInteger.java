package playground.leetcode3;

public class FindtheLargestAlmostMissingInteger {

    public int largestInteger(int[] nums, int k) {
        if (k == nums.length) {
            //return max
            int max = nums[0];
            for (int val : nums) {
                max = Math.max(max, val);
            }
            return max;
        }
        int[] count = new int[51];
        for (int val : nums) {
            count[val]++;
        }
        if (k == 1) {
            int i = 50;
            while (i >= 0) {
                if (count[i] == 1) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        int res = -1;
        if (count[nums[0]] == 1) {
            res = Math.max(res, nums[0]);
        }
        if (count[nums[nums.length - 1]] == 1) {
            res = Math.max(res,nums[ nums.length - 1]);
        }
        return res;
    }
}
