package playground.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumTotalDamageWithSpellCasting {

    int[] power;
    SimpleMultiCounter smc;
    Map<String, Long> memo; // Add memoization map

    public long maximumTotalDamage(int[] power) {
        this.power = power;
        smc = new SimpleMultiCounter();
        memo = new HashMap<>(); // Initialize memo
        return maximumTotalDamage(0);
    }

    public long maximumTotalDamage(int current) {
        if (current == power.length) {
            return 0;
        }

        long result;
        if (smc.get(power[current]) > 0) {
            smc.increment(power[current]);
            result = power[current] + maximumTotalDamage(current + 1);
            smc.decrement(power[current]);
        } else {
            long with = 0;
            if (smc.get(power[current] + 1) == 0 && smc.get(power[current] + 2) == 0
                    && smc.get(power[current] - 1) == 0 && smc.get(power[current] - 2) == 0) {
                smc.increment(power[current]);
                with = power[current] + maximumTotalDamage(current + 1);
                smc.decrement(power[current]);
            }
            long without = maximumTotalDamage(current + 1);
            result = Math.max(without, with);
        }

        return result;
    }

    public class SimpleMultiCounter {
        private final Map<Integer, Integer> counters = new HashMap<>();

        public void increment(int key) {
            counters.put(key, counters.getOrDefault(key, 0) + 1);
        }

        public void decrement(int key) {
            counters.put(key, counters.getOrDefault(key, 0) - 1);
        }

        public int get(int key) {
            return counters.getOrDefault(key, 0);
        }

    }
}
