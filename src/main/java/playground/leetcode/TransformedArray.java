package playground.leetcode;

public class TransformedArray {

    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                if (nums[i] > 0) {
                    int index = (i + nums[i]) % nums.length;
                    res[i] = nums[index];
                } else {
                    int index = (i + nums[i]) % nums.length;
                    if (index < 0) index += nums.length;
                    res[i] = nums[index];
                }
            }
        }
        return res;
    }

}
