package playground.leetcode;

public class WaterBottlesII {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = 0;
        int drink = 0;
        int full = numBottles;

        while (full > 0 || empty >= numExchange) {
            drink += full;
            empty += full;
            full = 0;
            while (empty >= numExchange) {
                empty -= numExchange;
                full++;
                numExchange++;
            }
        }

        return drink;
    }

}
