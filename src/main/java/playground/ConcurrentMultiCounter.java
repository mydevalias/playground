package playground;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentMultiCounter<T> {

    private final ConcurrentHashMap<T, AtomicInteger> trackerMap;

    public ConcurrentMultiCounter() {
        trackerMap = new ConcurrentHashMap<>();
    }

    public int incrementAndGet(final T key) {
        return trackerMap.computeIfAbsent(key, k -> new AtomicInteger(0))
                .incrementAndGet();
    }

    public int get(final T key) {
        AtomicInteger mapValue = trackerMap.get(key);
        if (mapValue == null) {
            return 0;
        }
        return mapValue.get();
    }
}
