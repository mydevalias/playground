package playground.leetcode;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        int consZero = s.charAt(0) == '0' ? 1 : 0;
        int consOne = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == s.charAt(i - 1)) {
                if (current == '0') {
                    consZero++;
                } else {
                    consOne++;
                }
            } else {
                //different
                res += Math.min(consOne, consZero);
                if (current == '0') {
                    consZero = 1;

                } else {
                    consOne = 1;
                }
            }
        }
        res += Math.min(consOne, consZero);
        return res;
    }

}
