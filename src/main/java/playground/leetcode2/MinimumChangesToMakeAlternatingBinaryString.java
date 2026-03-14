package playground.leetcode2;

public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        return Math.min(countWithExpected('0', s), countWithExpected('0', s));
    }

    private int countWithExpected(char ex, String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c != ex) {
                res++;
            }
            ex = next(ex);
        }
        return res;
    }

    char next(char current) {
        return current == '0' ? '1' : '0';
    }

}
