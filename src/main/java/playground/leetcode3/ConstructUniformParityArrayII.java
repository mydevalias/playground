package playground.leetcode3;

public class ConstructUniformParityArrayII {

    public boolean uniformArray(int[] nums1) {
            int minOdd = Integer.MAX_VALUE;
            int minEven = Integer.MAX_VALUE;

            for (int num : nums1) {
                if (num % 2 == 1) {
                    minOdd = Math.min(minOdd, num);
                } else {
                    minEven = Math.min(minEven, num);
                }
            }

            boolean noOdds = (minOdd == Integer.MAX_VALUE);
            boolean noEvens = (minEven == Integer.MAX_VALUE);

            if (noOdds || noEvens) {
                return true;
            }

            return minOdd < minEven;
    }

}
