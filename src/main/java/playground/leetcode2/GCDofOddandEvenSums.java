package playground.leetcode2;

public class GCDofOddandEvenSums {

    static long gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        return (int)gcd(n*n,n*(n+1));
    }

}
