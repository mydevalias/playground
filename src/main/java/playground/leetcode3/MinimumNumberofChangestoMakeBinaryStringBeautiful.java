package playground.leetcode3;

public class MinimumNumberofChangestoMakeBinaryStringBeautiful {

    public int minChanges(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i = i + 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                res++;
            }
        }
        return res;
    }

}
