package playground.leetcode3;

import java.util.*;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {

    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.addAll(Arrays.stream(nums).boxed().toList());
        int x = sum;
        while(!set.contains(x)){
            x++;
        }
        return x;

    }

}
