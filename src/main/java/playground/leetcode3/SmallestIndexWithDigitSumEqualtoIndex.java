package playground.leetcode3;

public class SmallestIndexWithDigitSumEqualtoIndex {

    public int smallestIndex(int[] nums) {
        int min = Math.min(nums.length, 50);
        for (int i = 0; i < min; i++) {
            if (summ(nums[i]) == i) {
                return i;
            }

        }
        return -1;
    }

    private int summ(int num) {
        int sum = 0;
        while (num > 0) {
            sum =sum + (num % 10);
            num = num / 10;
        }
        return sum;
    }

}
