package playground.leetcode;

public class BinaryGap {

    public int binaryGap(int n) {
        int res = 0;
        int prev = -1;
        int i = -1;
        while (n > 0) {
            i++;
            int c = n % 2;
            n = n / 2;
            if (c == 1) {
                if (prev == -1) {
                    prev = i;
                    continue;
                }
                res = Math.max(res, i-prev);
                prev = i;
            }
        }
        return res;
    }

}
