package playground.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckifStringsCanBeMadeEqualWithOperationsII {

    public boolean checkStrings(String s1, String s2) {
        return check(s1, s2, 0) && check(s1, s2, 1);
    }

    private static boolean check(String s1, String s2, int start) {
        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();
        for (int i = start; i < s1.length(); i = i + 2) {
            first.add(s1.charAt(i));
            second.add(s2.charAt(i));
        }
        Collections.sort(first);
        Collections.sort(second);
        return first.equals(second);
    }

}
