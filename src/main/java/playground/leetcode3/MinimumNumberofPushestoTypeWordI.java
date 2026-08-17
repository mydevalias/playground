package playground.leetcode3;

import java.util.*;

public class MinimumNumberofPushestoTypeWordI {

    public int minimumPushes(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(freq.keySet());
        Collections.sort(chars, (a, b) -> {
            return freq.get(b) - freq.get(a); // descending frequency
        });

        HashMap<Character, Integer> tap = new HashMap<>();
        for (int i = 0; i < chars.size(); i++) {
            tap.put(chars.get(i), (i / 8)+1);
        }

        int ret = 0;
        for (char c : word.toCharArray()) {
            ret += tap.get(c);
        }
        return ret;

    }


}
