package playground;

import java.util.HashMap;
import java.util.Map;

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