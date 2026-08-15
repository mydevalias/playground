package playground.leetcode3;

public class MaximumProductofTwoElementsinanArray {

    public int maxProduct(int[] nums) {
        int first = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int r = nums[i];
            if (first < r) {
                second = first;
                first = r;
            } else {
                if (second < r) {
                    second = r;
                }
            }
        }
        return (first-1) * (second-1);
    }

}
