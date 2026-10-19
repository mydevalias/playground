package playground.leetcode3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraysDistinctElementSumofSquaresI {

    public int sumCounts(List<Integer> nums) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                seen.add(nums.get(j));
                int cur = seen.size();
                res += cur*cur;
            }
        }
        return res;
    }

}
