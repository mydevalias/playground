package playground.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindXSumAllKLongSubarraysI {

    public int[] findXSum(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < res.length; i++) {
            Map<Integer, Integer> frec = countFrequencies(nums, i, i + k);
            res[i] = topX(frec, x);
        }

        return res;

    }

    private int topX(Map<Integer, Integer> frequencies, int x) {
        return frequencies.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int cmp = e2.getValue().compareTo(e1.getValue()); // frequency descending
                    if (cmp != 0) return cmp;
                    return e2.getKey().compareTo(e1.getKey()); // key descending
                })
                .limit(x)
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();

    }

    private Map<Integer, Integer> countFrequencies(int[] nums, int from, int to) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = from; i < to; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return map;
    }


}
