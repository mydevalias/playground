package playground.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumTotalDamageWithSpellCasting {

    int[] power;
    SimpleMultiCounter smc;

    public long maximumTotalDamage(int[] power) {
        this.power = power;
        smc = new SimpleMultiCounter();
        return maximumTotalDamage(0);
    }

    public long maximumTotalDamage(int current) {
        if (current == power.length) {
            return 0;
        }
        if (smc.get(power[current]) > 0) {
            smc.increment(power[current]);
            long l = power[current] + maximumTotalDamage(current + 1);
            smc.decrement(power[current]);
            return l;
        } else {
            long with = 0;
            if (smc.get(power[current] + 1) == 0 && smc.get(power[current] + 2) == 0
                    && smc.get(power[current] - 1) == 0 && smc.get(power[current] - 2) == 0) {
                smc.increment(power[current]);
                with = power[current] + maximumTotalDamage(current + 1);
                smc.decrement(power[current]);
            }
            long without = maximumTotalDamage(current + 1);
            return Math.max(without, with);
        }
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
