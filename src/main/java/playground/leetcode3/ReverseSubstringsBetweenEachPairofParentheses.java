package playground.leetcode3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseSubstringsBetweenEachPairofParentheses {

    public String reverseParentheses(String s) {
        return solve(s, 0, s.length());
    }

    private String solve(String s, int start, int end) {
        StringBuilder ret = new StringBuilder();

        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int close = findClose(s, i);
                StringBuilder current = new StringBuilder(solve(s, i + 1, close));
                ret.append(current.reverse());
                i = close;
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }

    private int findClose(String s, int open) {
        int depth = 0;
        for (int i = open; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
                if (depth == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

}
