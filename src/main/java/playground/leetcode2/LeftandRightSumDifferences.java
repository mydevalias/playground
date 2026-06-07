package playground.leetcode2;

public class LeftandRightSumDifferences {

    public int[] leftRightDifference(int[] nums) {
        int res[] = new int[nums.length];
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = sum;
            sum += nums[i];
        }

        sum = 0;
        for(int i=0;i<nums.length;i++){
            res[i] = Math.abs(res[i] -sum);
            sum = sum +nums[i];
        }

        return res;
    }
}
