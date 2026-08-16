package playground.leetcode3;

public class LongestSubsequenceWithNonZeroBitwiseXOR {
    public int longestSubsequence(int[] nums) {
        boolean allZero = true;
        int xorvalue = 0;
        for (int val : nums) {
            if (val != 0) {
                allZero = false;
            }
            xorvalue = xorvalue ^ val;
        }

        if (allZero) {
            return 0;
        }
        if (xorvalue != 0) {
            return nums.length;
        }
        return nums.length-1;
    }
}
