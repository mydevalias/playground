package playground.leetcode2;

import java.util.HashMap;
import java.util.TreeMap;

public class MaximumIceCreamBars {


    public int maxIceCream(int[] costs, int coins) {
        CountMap cm = new CountMap();
        for (int c : costs) {
            cm.add(c);
        }
        int val = 0;
        for (var kv : cm.map.entrySet()) {
            int max = kv.getValue() * kv.getKey();
            if (max <= coins) {
                coins -= max;
                val = val + kv.getValue();
            } else {
                val = val + coins / kv.getKey();
                coins = coins % kv.getKey();
            }
            if (coins == 0) {
                return val;
            }
            if (coins < kv.getKey()) {
                return val;
            }
        }
        return val;
    }

    class CountMap {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();

        public boolean contains(int val) {
            return map.containsKey(val);
        }

        public void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

    }

}
