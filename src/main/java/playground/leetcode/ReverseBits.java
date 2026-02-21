package playground.leetcode;

public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int c = n % 2;
            n = n / 2;
            res = res * 2 + c;
        }
        return res;
    }

}
