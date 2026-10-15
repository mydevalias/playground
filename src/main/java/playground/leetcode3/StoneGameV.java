package playground.leetcode3;

public class StoneGameV {

    RangeSum rs;

    public int stoneGameV(int[] stoneValue) {
        rs = new RangeSum(stoneValue);
        return bk(0, stoneValue.length - 1);
    }

    private int bk(int start, int end) {
        if (start == end) {
            return 0;
        }
        int max = -1;
        for (int i = start; i < end; i++) {
            int sumLeft = rs.sum(start, i);
            int sumRight = rs.sum(i + 1, end);
            if (sumRight == sumLeft) {
                int cutLeft = bk(start, i);
                int cutRight = bk(i + 1, end);
                max = Math.max(cutLeft + sumLeft, max);
                max = Math.max(cutRight + sumRight, max);
            } else {
                if (sumRight > sumLeft) {
                    int cutLeft = bk(start, i);
                    max = Math.max(cutLeft + sumLeft, max);
                } else {
                    int cutRight = bk(i + 1, end);
                    max = Math.max(cutRight + sumRight, max);
                }
            }
        }
        return max;
    }

    class RangeSum {
        private final long[] prefix;

        public RangeSum(int[] arr) {
            prefix = new long[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                prefix[i + 1] = prefix[i] + arr[i];
            }
        }

        // sum of arr[i..j], inclusive
        public int sum(int i, int j) {
            return (int) (prefix[j + 1] - prefix[i]);
        }
    }
}
