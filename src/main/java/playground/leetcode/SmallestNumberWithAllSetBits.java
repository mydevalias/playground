package playground.leetcode;

public class SmallestNumberWithAllSetBits {


    public static int binaryDigitsCount(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 2;
        }
        return count;
    }

    public int smallestNumber(int n) {
        return (int)Math.pow(2, binaryDigitsCount(n))-1;
    }

}
