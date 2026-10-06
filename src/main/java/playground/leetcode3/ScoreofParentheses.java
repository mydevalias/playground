package playground.leetcode3;

public class ScoreofParentheses {
    String s;

    public int scoreOfParentheses(String s) {
        this.s = s;
        return scode(0, s.length());
    }

    private int scode(int start, int length) {
        int res = 0;
        int open = 0;
        int cs = start;
        for (int i = start; i < length; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                open--;
                if (open == 0) {
                    if (i == cs + 1) {
                        res = res + 1;
                    } else {
                        res = res + 2 * scode(cs + 1, i);
                    }
                    cs = i + 1;
                }
            }
        }
        return res;
    }
}
