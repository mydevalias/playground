package playground.leetcode;

import java.util.Arrays;

public class TheTwoSneakyNumbersDigitville {

    public int[] getSneakyNumbers2(int[] nums) {
        int[] res = new int[2];
        int j = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res[j] = nums[i];
                j++;
            }
        }
        return res;
    }

    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int[] count = new int[nums.length];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] > 1) {
                res[j] = nums[i];
                j++;
            }
        }
        return res;
    }

}
