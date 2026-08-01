package playground.leetcode3;

public class FindGreatestCommonDivisorofArray {


    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        return gcd(max, min);
    }

    private int gcd(int max, int min) {
        if (min == 0) {
            return max;
        }
        return gcd(min, max % min);
    }
}
