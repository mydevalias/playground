package playground.leetcode3;

public class MinimumOperationstoSortaString {
    public int minOperations(String s) {
        boolean sorted = true;
        char min = s.charAt(0);
        char max = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < s.charAt(i - 1)) {
                sorted = false;
            }
            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);
        }
        if (sorted) {
            return 0;
        }
        if (s.length() == 2) {
            return -1;
        }
        if (s.charAt(s.length() - 1) == max) {
            return 1;
        }
        if (s.charAt(0) == min) {
            return 1;
        }
        if (s.indexOf(min) == s.length() - 1 && s.lastIndexOf(max) == 0) {
            return 3;
        }

        return 2;
    }
}
