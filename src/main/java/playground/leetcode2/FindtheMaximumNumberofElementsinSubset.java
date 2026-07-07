package playground.leetcode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindtheMaximumNumberofElementsinSubset {

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int val : nums) {
            count.merge(val, 1, Integer::sum);
        }

        HashSet<Integer> visited = new HashSet<>();
        int res = 1;
        for (int val : nums) {
            if (visited.contains(val)) continue;
            visited.add(val);

            if (val == 1) {
                int ones = count.get(1);
                res = Math.max(res, ones % 2 == 0 ? ones - 1 : ones);
                continue;
            }

            int c = 0;
            long cur = val;
            while (count.getOrDefault((int) cur, 0) >= 2) {
                c++;
                cur = cur * cur;
                if (cur > 1_000_000_000L) break;
            }
            if (cur <= 1_000_000_000L && count.getOrDefault((int) cur, 0) >= 1) {
                c++;
            }

            res = Math.max(2 * c - 1, res);
        }
        return res;
    }

}
