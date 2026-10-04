package playground.leetcode3;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int res = 0;
        int open = 0;
        int closed = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                closed++;
            }
            if (open == closed) {
                res = Math.max(res, open * 2);
            } else {
                if (closed > open) {
                    open = 0;
                    closed = 0;
                }
            }
        }
         open = 0;
         closed = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                closed++;
            }
            if (open == closed) {
                res = Math.max(res, open * 2);
            } else {
                if (open > closed) {
                    open = 0;
                    closed = 0;
                }
            }
        }

        return res;
    }

}
