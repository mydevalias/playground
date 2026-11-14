package playground.leetcode3;

public class LongestStrictlyIncreasingorStrictlyDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int maxIncreasing = 0;
        int current = 0;
        int maxDecressing =0;
        int curDec = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                current++;
            } else {
                current = 0;
            }
            maxIncreasing = Math.max(maxIncreasing, current);

            if (nums[i - 1] > nums[i]) {
                curDec++;
            }else{
                curDec = 0;
            }
            maxDecressing = Math.max(maxDecressing, curDec);
        }
        return Math.max(maxDecressing, maxIncreasing);
    }

}
