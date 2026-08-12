package playground.leetcode3;

public class MaximumProductofTwoDigits {

    public int maxProduct(int n) {
        int first = 0;
        int second = 0;
        while (n > 0) {
            int r = n % 10;
            n = n / 10;
            if (first < r) {
                second = first;
                first = r;
            } else {
                if (second < r) {
                    second = r;
                }
            }
        }
        return first * second;
    }

}
