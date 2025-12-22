package playground.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialTriplets {

    final int MOD = 1000000007;

    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> countAll = new HashMap<>();
        for (int val : nums) {
            countAll.put(val, countAll.getOrDefault(val, 0) + 1);
        }
        long res = 0;
        Map<Integer, Integer> countPrev = new HashMap<>();
        for (int val : nums) {
            int target = val * 2;
            countAll.put(val, countAll.get(val) - 1);

            int left = countPrev.getOrDefault(target, 0);
            int right = countAll.getOrDefault(target, 0);
            res = (res + (long) left * right) % MOD;
            countPrev.put(val, countPrev.getOrDefault(val, 0) + 1);
        }
        return (int) res;
    }

}
