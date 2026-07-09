package playground.leetcode2;

public class ConcatenateNonZeroDigitsandMultiplybySumII {

    final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = process(s, start, end);

        }
        return res;


    }

    private int process(String s, int start, int end) {
        long res = 0;
        long sum = 0;
        for (int i = start; i <= end; i++) {
            int c = s.charAt(i) - '0';
            if (c > 0) {
                res = (res * 10 + c) % MOD;
                sum = (sum + c) % MOD;
            }
        }
        return (int)((res * sum) % MOD);
    }

}
