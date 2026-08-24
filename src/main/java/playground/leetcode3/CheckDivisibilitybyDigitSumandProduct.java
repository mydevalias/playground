package playground.leetcode3;

public class CheckDivisibilitybyDigitSumandProduct {


    public boolean checkDivisibility(int n) {
        int nn = n;
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int t = n % 10;
            product = product * t;
            sum = sum + t;
            n = n / 10;
        }
        if (product + sum == 0) {
            return false;
        }
        return nn % (product + sum) == 0;
    }
}
