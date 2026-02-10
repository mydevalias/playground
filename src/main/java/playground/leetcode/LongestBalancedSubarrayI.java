package playground.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestBalancedSubarrayI {

    public int longestBalanced(int[] nums) {
        int res = 0;
        Set<Integer> d2 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i < res) {
                break;
            }
            d2.clear();
            n2.clear();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    d2.add(nums[j]);
                } else {
                    n2.add(nums[j]);
                }
                if (d2.size() == n2.size()) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

}
