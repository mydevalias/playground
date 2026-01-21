package playground.leetcode;

import java.util.List;

public class ConstructTheMinimumBitwiseArrayI {

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            result[i] = -1;
            for (int j = 1; j < curr; j++) {
                if ((j | (j + 1)) == curr) {
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }

}
