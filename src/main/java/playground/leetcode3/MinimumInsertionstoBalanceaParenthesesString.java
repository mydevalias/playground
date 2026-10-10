package playground.leetcode3;

public class MinimumInsertionstoBalanceaParenthesesString {

    public int minInsertions(String s) {
        int need = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need += 2;
                if (need % 2 == 1) {   // a single ')' got cut off by this '('
                    res++;             // insert ')' to complete the pair
                    need--;
                }
            } else {
                need--;
                if (need == -1) {      // ')' with nothing open
                    res++;             // insert '(' before it
                    need = 1;          // that '(' still needs one more ')'
                }
            }
        }
        return res + need;
    }
}
