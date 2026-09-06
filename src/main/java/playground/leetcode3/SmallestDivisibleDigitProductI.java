package playground.leetcode3;

public class SmallestDivisibleDigitProductI {

    public int smallestNumber(int n, int t) {
        for (int i = n; i < 101; i++) {
            if (sum(i) % t == 0) {
                return i;
            }
        }

        return -1;
    }

    private long sum(int i) {
        long product = 1;
        while (i > 0) {
            product = product * (i % 10);
            i = i / 10;
        }
        return product;
    }

}
