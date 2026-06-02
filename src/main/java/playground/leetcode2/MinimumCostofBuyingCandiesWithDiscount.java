package playground.leetcode2;

import java.util.Arrays;

public class MinimumCostofBuyingCandiesWithDiscount {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        for (int i = cost.length - 1; i >= 0; i = i - 3) {
            if (i > 3) {
                res = res + cost[i] + cost[i - 1];
            }
        }
        return res;
    }

}
