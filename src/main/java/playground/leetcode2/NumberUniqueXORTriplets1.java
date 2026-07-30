package playground.leetcode2;

import java.util.HashSet;
import java.util.Set;

public class NumberUniqueXORTriplets1 {

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = Integer.highestOneBit(n) << 1;

        int[] doubles = new int[max];
        int[] totals = new int[max];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                doubles[nums[i] ^ nums[j]] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < max; j++) {
                if (doubles[j] == 1) {
                    totals[j ^ nums[i]] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < max; i++) {
            res += totals[i];
        }
        return res;
    }
    public int slow(int[] nums) {
        int n = nums.length;
        Set<Integer> doubles = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                doubles.add(nums[i] ^ nums[j]);
            }
        }
        Set<Integer> totals = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int val : doubles) {
                totals.add(val ^ nums[i]);
            }
        }
        return totals.size();

    }

}
