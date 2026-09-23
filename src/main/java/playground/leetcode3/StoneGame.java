package playground.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class StoneGame {

    int[] piles;
    Map<StateKey, Boolean> memo = new HashMap<>();

    record StateKey(int delta, int start, int end, boolean playerOne) {}

    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        return pdw(0, 0, piles.length, true);
    }

    private boolean pdw(int delta, int start, int end, boolean playerOne) {
        if (start == end) {
            return delta > 0;
        }
        StateKey key = new StateKey(delta, start, end, playerOne);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean result;
        if (playerOne) {
            result = pdw(delta+piles[start], start+1, end, false)
                    ||  pdw(delta+piles[end-1], start, end-1, false);
        } else {
            result = pdw(delta-piles[start], start+1, end, true)
                    &&  pdw(delta-piles[end-1], start, end-1, true);
        }
        memo.put(key, result);
        return result;
    }
}
