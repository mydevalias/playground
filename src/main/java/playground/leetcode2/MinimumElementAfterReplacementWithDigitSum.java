package playground.leetcode2;

public class MinimumElementAfterReplacementWithDigitSum {

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int val : nums) {
            min = Math.min(min, sum(val));
        }
        return min;
    }

    private int sum(int val) {
        int sum = 0;
        while (val != 0) {
            sum = sum + val % 10;
            val = val / 10;
        }
        return sum;
    }

}
