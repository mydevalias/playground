package playground.leetcode3;

public class LongestValidParentheses {

    private Boolean[][] memo;

    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n + 1][n + 1];
        return parse(s, 0, 0);
    }

    private boolean parse(String s, int i, int open) {
        if (open < 0) {
            return false;
        }
        if (i == s.length()) {
            return open == 0;
        }
        if (memo[i][open] != null) {
            return memo[i][open];
        }

        boolean result;
        char c = s.charAt(i);
        if (c == '(') {
            result = parse(s, i + 1, open + 1);
        } else if (c == ')') {
            result = parse(s, i + 1, open - 1);
        } else {
            result = parse(s, i + 1, open + 1)
                    || parse(s, i + 1, open - 1)
                    || parse(s, i + 1, open);
        }

        memo[i][open] = result;
        return result;
    }

}
