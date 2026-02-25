package playground.leetcode;

public class LongestBalancedSubstringII {

    public int longestBalanced(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < longest) {
                break;
            }
            int a = 0, b = 0, c = 0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == 'a') a++;
                else if (ch == 'b') b++;
                else c++;
                int balanced = isBalanced(a, b, c);
                if (balanced != -1) {
                    longest = Math.max(longest, balanced);
                }
            }
        }

        return longest;
    }

    private int isBalanced(int a, int b, int c) {
        if (a == b && b == c) return a + b + c;
        if (a == 0 && b == c) return b + c;
        if (b == 0 && a == c) return a + c;
        if (c == 0 && a == b) return a + b;
        if (a == 0 && b == 0) return c;
        if (a == 0 && c == 0) return b;
        if (b == 0 && c == 0) return a;
        return -1;
    }

}
