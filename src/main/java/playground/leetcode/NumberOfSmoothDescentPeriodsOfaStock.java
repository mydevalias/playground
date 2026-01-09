package playground.leetcode;

public class NumberOfSmoothDescentPeriodsOfaStock {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int currentLength = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i-1] - 1) {
                //descending
                currentLength++;
            } else {
                res += count(currentLength);
                currentLength = 1;
            }
        }

        res += count(currentLength);

        return res;
    }

    private static long count(long currentLength) {
        //n*(n+1)/2
        return currentLength * (currentLength + 1) / 2;
    }
}
