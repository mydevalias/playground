package playground.leetcode;

public class SmallestIntegerDivisiblebyK {

    public int smallestRepunitDivByK(int k) {
        int r = 0;
        for (int i = 1; i <= k; i++) {
            int n = r * 10 + 1;
            r = n % k;
            if (r % k == 0) {
                return i;
            }
        }
        return -1;
    }

}
