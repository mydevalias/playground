package playground.leetcode;

import java.util.Arrays;

public class NextGreaterNumericallyBalancedNumber {


    public int nextBeautifulNumber(int n) {
        while (n != Integer.MAX_VALUE) {
            n++;
            if (isBeautifull(n)) {
                return n;
            }
        }
        return n;
    }

    int[] counts = new int[10];

    private boolean isBeautifull(int n) {
        Arrays.fill(counts, 0);
        int max = 0;
        while (n > 0) {
            int r = n % 10;
            if (r == 0) {
                return false;
            }
            max = Math.max(max, r);
            counts[r]++;
            n = n / 10;

        }
        for (int i = 1; i <10; i++) {
            if (counts[i]!=0 && counts[i] != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       var ng = new NextGreaterNumericallyBalancedNumber();
        System.out.println(ng.isBeautifull(22));
    }
}
