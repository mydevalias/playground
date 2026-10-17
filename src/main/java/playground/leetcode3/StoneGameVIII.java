package playground.leetcode3;

public class StoneGameVIII {

    RangeSum rs;

    public int stoneGameVIII(int[] stones) {
        rs = new RangeSum(stones);
        return bk(0, stones.length);
    }

    private int bk(int i, int n) {
        if (i == n - 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int j = i + 1; j < n; j++) {
            int gain = rs.sum(0, j);
            int rest = bk(j, n);
            max = Math.max(max, gain - rest);
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

        public int sum(int i, int j) {
            return (int) (prefix[j + 1] - prefix[i]);
        }
    }

}
