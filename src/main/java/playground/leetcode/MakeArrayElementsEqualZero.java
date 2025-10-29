package playground.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayElementsEqualZero {

    public int countValidSelections(int[] nums) {
        int success = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (makeZero(Arrays.copyOf(nums, nums.length), i, 1)) {
                    success++;
                }
                if (makeZero(Arrays.copyOf(nums, nums.length), i, -1)) {
                    success++;
                }
            }
        }
        return success;
    }

    private boolean makeZero(int[] ints, int pos, int increment) {
        while (pos >= 0 && pos < ints.length) {
            if (ints[pos] != 0)   {
                ints[pos]--;
                increment = increment * -1;
            }
            pos = pos + increment;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                return false;
            }
        }
        return true;
    }


}
