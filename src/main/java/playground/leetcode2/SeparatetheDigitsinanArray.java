package playground.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class SeparatetheDigitsinanArray {

    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> all = new ArrayList<>(nums.length);
        List<Integer> current = new ArrayList<>();
        for (int val : nums) {
            if (val == 0) {
                all.add(0);
                continue;
            }
            int c = val;
            current.clear();
            while (c != 0) {
                current.add(c % 10);
                c = c / 10;
            }
            List<Integer> reversed = current.reversed();
            all.addAll(reversed);
        }
        return all.stream().mapToInt(Integer::intValue).toArray();
    }

}
