package playground.leetcode;

import java.util.List;

public class ConstructTheMinimumBitwiseArrayII {

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            result[i] = -1;
            int d = 1;
            while ((curr & d) != 0) {
                result[i] = curr - d;
                d = d * 2;
            }
        }
        return result;
    }

}
