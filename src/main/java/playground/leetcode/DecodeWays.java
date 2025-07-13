package playground.leetcode;

/**
 * https://leetcode.com/problems/word-break/description/
 */
public class DecodeWays {

    private String s;
    private Integer[] memo;

    public int numDecodings(String s) {
        this.s = s;
        memo = new Integer[s.length()];
        return numDecodings(0);
    }

    private int numDecodings(int pos) {
        if (pos >= s.length()) {
            return 1;
        }
        if (memo[pos] != null) {
            return memo[pos];
        }
        int ret = 0;
        int one = stepOne(pos);
        if (one > -1 && one < 27) {
            ret += numDecodings(pos + 1);
        }
        int two = stepTwo(pos);
        if (two > -1 && two < 27) {
            ret += numDecodings(pos + 2);
        }
        memo[pos] = ret;
        return ret;
    }

    private int stepOne(int pos) {
        int numericValue = s.charAt(pos) - '0';
        if (numericValue == 0) {
            return -1;
        }
        return numericValue;
    }

    private int stepTwo(int pos) {
        if (pos + 1 >= s.length()) {
            return -1;
        }
        int numericValue = s.charAt(pos) - '0';
        if (numericValue == 0) {
            return -1;
        }
        int numericValue2 = s.charAt(pos + 1) - '0';
        return numericValue * 10 + numericValue2;
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
//        System.out.println(dw.numDecodings("12"));
        System.out.println(dw.numDecodings("27"));
    }


}
