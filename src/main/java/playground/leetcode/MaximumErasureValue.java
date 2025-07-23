package playground.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> wl = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            while (wl.contains(nums[i])) {
                wl.remove(nums[left]);
                sum = sum - nums[left];
                left++;
            }

            sum = sum + nums[i];
            wl.add(nums[i]);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var mev = new MaximumErasureValue();
        System.out.println(mev.maximumUniqueSubarray(new int[]{10000,1,10000,1,1,1,1,1,1}));
//        System.out.println(mev.maximumUniqueSubarray(new int[]{2, 4, 5, 6}));
//        System.out.println(mev.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
//        System.out.println(mev.maximumUniqueSubarray(new int[]{187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133,
//                666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970,
//                306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971,
//                458, 409, 886, 434}));
    }
}
