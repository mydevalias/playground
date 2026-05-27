package playground.leetcode2;

import java.util.HashSet;
import java.util.Set;

public class CounttheNumberofSpecialCharactersI {

    public int numberOfSpecialChars(String word) {
        Set<Character> all = new HashSet<>();
        for (char c : word.toCharArray()) {
            all.add(c);
        }
        int res = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (all.contains(c) && all.contains(Character.toUpperCase(c))) {
                res++;
            }
        }
        return res;
    }

}
