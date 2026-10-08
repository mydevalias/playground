package playground.leetcode3;

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int open = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (open < 0) {
                    res += (-open);
                    open = 0;
                }
                open++;
            } else {
                open--;
            }
        }
        res += Math.abs(open);
        return res;
    }

}
