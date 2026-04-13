package playground.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinimumDistanceBetweenThreeEqualElementsII {
    public int minimumDistance(int[] nums) {
        int ret = Integer.MAX_VALUE;
        HashMap<Integer, ArrayList<Integer>> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> ar = positions.get(nums[i]);
            if (ar == null) {
                ar = new ArrayList<>();
                positions.put(nums[i], ar);
            }
            ar.add(i);
        }
        for (ArrayList<Integer> ar : positions.values()) {
            for (int i = 0; i < ar.size() - 2; i++) {
                ret = Math.min(ret, Math.abs(ar.get(i) - ar.get(i + 1)) + Math.abs(ar.get(i + 1) - ar.get(i + 2)) + Math.abs(ar.get(i + 2) - ar.get(i)));
                if (ret == 0) {
                    return 0;
                }
            }
        }

        if (ret == Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }
}
