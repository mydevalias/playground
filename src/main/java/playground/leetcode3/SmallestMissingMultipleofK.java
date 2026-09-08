package playground.leetcode3;

import java.util.TreeSet;

public class SmallestMissingMultipleofK {

    public int missingMultiple(int[] nums, int k) {
        TreeSet<Integer> multipliers = new TreeSet<>();
        for (int val : nums) {
            if (val % k == 0) {
                multipliers.add(val);
            }
        }
        long current = k;
        while (current < Integer.MAX_VALUE) {
            if (!multipliers.contains((int)current)) {
                return (int) current;
            }
            current += k;
        }
        return -1;

    }

}
