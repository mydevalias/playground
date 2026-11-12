package playground.leetcode3;

public class MinimumCosttoAcquireRequiredItems {

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res = 0;
        if (costBoth < cost1 + cost2) {
            int buy = Math.min(need1, need2);
            res = (long) buy * costBoth;
            need1 -= buy;
            need2 -= buy;
        }
        if (costBoth < cost1) {
            res = res + (long) need1 * costBoth;
            need2 -= need1;
            need1 = 0;
        } else {
            res = res + (long) need1 * cost1;
            need1 = 0;
        }
        if (need2 > 0) {
            if (costBoth < cost2) {
                res = res + (long) need2 * costBoth;
            } else {
                res = res + (long) need2 * cost2;
            }
        }

        return res;
    }

}
