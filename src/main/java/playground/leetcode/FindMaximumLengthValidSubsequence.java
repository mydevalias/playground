package playground.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description
 */
public class FindMaximumLengthValidSubsequence {


    public int maximumLength(int[] nums) {
        int res = findFor(nums, new int[]{0, 0});
        res = Math.max(res, findFor(nums, new int[]{0, 1}));
        res = Math.max(res, findFor(nums, new int[]{1, 0}));
        res = Math.max(res, findFor(nums, new int[]{1, 1}));

        return res;
    }

    private static int findFor(int[] nums, int[] bp) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == bp[count % 2]) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        var t = new FindMaximumLengthValidSubsequence();
        System.out.println(t.maximumLength(new int[]{1, 2, 3, 4}));
        System.out.println(t.maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
        System.out.println(t.maximumLength(new int[]{1, 3}));
        System.out.println(t.maximumLength(new int[]{1, 8, 4, 2, 4}));
    }
}
