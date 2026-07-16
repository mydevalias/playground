package playground.leetcode2;

import java.util.HashMap;
import java.util.Map;

public class TotalWavinessofNumbersinRangeII {

    int hits = 0, misses = 0;
    private Map<Long, Long> cache = new HashMap<>();

    public long totalWaviness(long num1, long num2) {
        long res = 0;
        for (long i = num1; i <= num2; i++) {
            res += countHelper(i / 10, i % 10);
        }
        System.out.println(hits+" "+misses);
        return res;

    }

    private long countHelper(long n, long last) {
        if (n < 10) return 0;

        if (n < 100) {
            long middle = n % 10;
            long first = n / 10;
            long c = 0;
            if (middle > first && middle > last) c++;
            if (middle < first && middle < last) c++;
            return c;
        }

        long key = n * 10 + last;
        if (cache.containsKey(key)) {
            hits++;
            return cache.get(key);
        }
        misses++;

        long middle = n % 10;
        long first = (n / 10) % 10;
        long remainder = n / 10;

        long c = countHelper(remainder, middle);

        if (middle > first && middle > last) c++;
        if (middle < first && middle < last) c++;

        cache.put(key, c);
        return c;
    }

    public static void main(String[] args) {
        new TotalWavinessofNumbersinRangeII().totalWaviness(278931, 4080530);
    }

}
