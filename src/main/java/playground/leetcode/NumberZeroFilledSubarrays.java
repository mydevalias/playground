package playground.leetcode;

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/description/?envType=daily-question&envId=2025-08-19
 */
public class NumberZeroFilledSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        int res = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                current++;
                res += current;
            } else {
                current = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberZeroFilledSubarrays x = new NumberZeroFilledSubarrays();
//        System.out.println(x.zeroFilledSubarray(new int[]{}));
    }

}
