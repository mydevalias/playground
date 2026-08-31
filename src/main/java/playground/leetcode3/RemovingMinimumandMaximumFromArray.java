package playground.leetcode3;

public class RemovingMinimumandMaximumFromArray {

    public int minimumDeletions(int[] nums) {
        int posMin = 0;
        int posMax = 0;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                posMax = i;
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
                posMin = i;
            }
        }

        int leftBoth = Math.max(posMax, posMin) + 1;
        int leftRight = nums.length - Math.min(posMax, posMin);
        int both = (Math.min(posMax, posMin) + 1) + (nums.length - Math.max(posMax, posMin));
        return Math.min(Math.min(leftBoth, leftRight), both);
    }

}
