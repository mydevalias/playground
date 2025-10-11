package playground.leetcode;

/**
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/
 */
public class FindTriangularSumArray {

    public int triangularSum(int[] nums) {
        for (int red = nums.length; red > 0; red--) {
            for (int i = 0; i < red; i++) {
                nums[i]= (nums[i] + nums[i+1]) % 10;
            }
        }
        return nums[0];
    }

}
