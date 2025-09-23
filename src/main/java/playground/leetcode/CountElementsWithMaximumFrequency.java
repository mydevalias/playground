package playground.leetcode;

import java.util.HashMap;

public class CountElementsWithMaximumFrequency {

    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int el : nums) {
            Integer c = hm.get(el);
            if (c == null) {
                c = 0;
            }
            c++;
            hm.put(el, c);
        }
        int max = 0;
        int count = 0;
        for (int k : hm.values()) {
            if (max == k) {
                count++;
            } else {
                if (max < k) {
                    max = k;
                    count = 1;
                }
            }
        }
        return max * count;
    }
}
