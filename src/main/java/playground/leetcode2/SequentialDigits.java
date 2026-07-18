package playground.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        String comb = "123456789";
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        List<Integer> res = new ArrayList<>();

        for (int len = minLen; len <= maxLen; len++) {
            for (int start = 0; start + len <= 9; start++) {
                int val = Integer.parseInt(comb.substring(start, start + len));
                if (val >= low && val <= high) {
                    res.add(val);
                }
            }
        }
        return res;
    }

}
