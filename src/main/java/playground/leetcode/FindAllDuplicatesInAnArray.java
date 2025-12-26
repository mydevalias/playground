package playground.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int v : nums) {
            if (set.contains(v)) {
                res.add(v);
            }
            set.add(v);
        }
        return res;
    }

}
