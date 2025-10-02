package playground.leetcode;

public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0;
        int drink = 0;
        int full = numBottles;
        while (full > 0) {
            drink += full;
            int pe = empty;
            empty = (full + pe)  % numExchange;
            full = (full + pe) / numExchange;
        }
        return drink;
    }


}
