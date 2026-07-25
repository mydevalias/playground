package playground.leetcode2;

import java.util.HashSet;
import java.util.Set;

public class NumberofUniqueXORTripletsII {

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int[] doubles = new int[2048];
        int[] totals = new int[2048];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                doubles[nums[i] ^ nums[j]] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2048; j++) {
                if (doubles[j] == 1) {
                    totals[j ^ nums[i]] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 2048; i++) {
            res += totals[i];
        }
        return res;

    }

}
