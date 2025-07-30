package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SmallestSubarraysWiteMaximumBitwiseOR {

    private int[] nums;
    private List<Integer> result;
    private int max;

    public int[] smallestSubarrays(int[] nums) {
        this.nums = nums;
        max = -1;
        bk(0, new ArrayList<>(nums.length), -1);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void bk(int pos, List<Integer> current, int csor) {
        if (pos == nums.length) {
            if (current.size() < 2) {
                return;
            }
            if (csor > max) {
                max = csor;
                result = new ArrayList<>(current);
                return;
            }
            if (csor == max) {
                if (current.size() < result.size()) {
                    result = new ArrayList<>(current);
                }
            }
            return;
        }
        current.add(nums[pos]);
        bk(pos + 1, current, xsor(pos, csor));
        current.removeLast();
        bk(pos + 1, current, csor);
    }

    private int xsor(int pos, int csor) {
        if (csor == -1) {
            return nums[pos];
        }
        return csor ^ nums[pos];
    }

}
